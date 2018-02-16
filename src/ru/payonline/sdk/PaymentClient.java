package ru.payonline.sdk;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

public final class PaymentClient {

    private IPaymentSetting settings;

    public String getPaymentLink(PaymentLinkRequest request) throws PaymentClientException {
        this.settings = new DefaultPaymentSetting();
        return generatePaymentFormUrl(request);
    }

    public String getPaymentLink(PaymentLinkRequest request, IPaymentSetting setting) throws PaymentClientException {
        this.settings = setting;
        return generatePaymentFormUrl(request);
    }

    public PayResponse pay(PayRequest request) throws PaymentClientException {

        this.settings = new DefaultPaymentSetting();
        return makePay(request);
    }

    public PayResponse pay(PayRequest request, IPaymentSetting setting) throws PaymentClientException {
        this.settings = setting;
        return makePay(request);
    }

    public Process3DsResponse process3Ds(Process3DsRequest request) throws PaymentClientException {
        this.settings = new DefaultPaymentSetting();
        return finish3Ds(request);
    }

    public Process3DsResponse process3Ds(Process3DsRequest request, IPaymentSetting setting) throws PaymentClientException {
        this.settings = setting;
        return finish3Ds(request);
    }

    private String generatePaymentFormUrl(PaymentLinkRequest request) throws PaymentClientException {
        Map<String,String> query = new LinkedHashMap<>();
        query.put("MerchantId", String.valueOf(request.getMerchantId()));
        query.put("OrderId", request.getOrderId());
        query.put("Amount", request.getAmount());
        query.put("Currency", request.getCurrency());

        Map<String,String> signature = new LinkedHashMap<>(query);
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getValidUntil())) {
            signature.put("ValidUntil", request.getValidUntil());
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getOrderDescription())) {
            signature.put("OrderDescription", request.getOrderDescription());
        }
        signature.put("PrivateSecurityKey", request.getPrivateSecurityKey());

        String secureParams = PayOnlineUtils.createQueryString(signature);
        String securityKey = PayOnlineUtils.getMD5Hash(secureParams);

        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getValidUntil())) {
            query.put("ValidUntil", PayOnlineUtils.urlEncodeUTF8(request.getValidUntil()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getOrderDescription())) {
            query.put("OrderDescription", PayOnlineUtils.urlEncodeUTF8(request.getOrderDescription()));
        }

        query.put("SecurityKey", securityKey);

        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getEmail())) {
            query.put("Email", request.getEmail());
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getReturnUrl())) {
            query.put("ReturnUrl", request.getReturnUrl());
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getFailUrl())) {
            query.put("FailUrl", request.getFailUrl());
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getCustomData())) {
            Map<String, String> customData = PayOnlineUtils.parseQueryString(request.getCustomData());
            query.putAll(customData);
        }

        StringBuilder url = new StringBuilder();
        url.append(this.settings.getHost());
        url.append(this.settings.getLanguage());
        url.append("/payment/?");
        url.append(PayOnlineUtils.createQueryString(query));

        URI uri;
        try {
            uri = new URI(url.toString());
        } catch (Exception e){
            throw new PaymentClientException("There was an error creating URI", e);
        }

        return uri.toString();
    }

    private PayResponse makePay(PayRequest request) throws PaymentClientException {
        Map<String,String> query = new LinkedHashMap<>();
        query.put("MerchantId", String.valueOf(request.getMerchantId()));
        query.put("OrderId", request.getOrderId());
        query.put("Amount", request.getAmount());
        query.put("Currency", PayOnlineUtils.urlEncodeUTF8(request.getCurrency()));

        Map<String,String> signature = new LinkedHashMap<>(query);
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getOrderDescription())) {
            signature.put("OrderDescription", request.getOrderDescription());
        }
        signature.put("PrivateSecurityKey", request.getPrivateSecurityKey());

        String secureParams = PayOnlineUtils.createQueryString(signature);
        String securityKey = PayOnlineUtils.getMD5Hash(secureParams);

        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getOrderDescription())) {
            query.put("OrderDescription", PayOnlineUtils.urlEncodeUTF8(request.getOrderDescription()));
        }

        query.put("SecurityKey", securityKey);

        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getIp())) {
            query.put("Ip", PayOnlineUtils.urlEncodeUTF8(request.getIp()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getEmail())) {
            query.put("Email", PayOnlineUtils.urlEncodeUTF8(request.getEmail()));
        }

        query.put("CardHolderName", PayOnlineUtils.urlEncodeUTF8(request.getCardHolderName()));
        query.put("CardNumber", request.getCardNumber());
        query.put("CardExpDate", request.getCardExpDate());
        query.put("CardCvv", request.getCardCvv());

        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getCountry())) {
            query.put("Country",PayOnlineUtils.urlEncodeUTF8(request.getCountry()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getCity())) {
            query.put("City", PayOnlineUtils.urlEncodeUTF8(request.getCity()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getAddress())) {
            query.put("Address", PayOnlineUtils.urlEncodeUTF8(request.getAddress()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getZip())) {
            query.put("Zip", PayOnlineUtils.urlEncodeUTF8(request.getZip()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getState())) {
            query.put("State", PayOnlineUtils.urlEncodeUTF8(request.getState()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getPhone())) {
            query.put("Phone", PayOnlineUtils.urlEncodeUTF8(request.getPhone()));
        }
        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getIssuer())) {
            query.put("Issuer", PayOnlineUtils.urlEncodeUTF8(request.getIssuer()));
        }

        StringBuilder url = new StringBuilder();
        url.append(this.settings.getHost());
        url.append("payment/transaction/auth/");

        URI uri;
        try {
            uri = new URI(url.toString());
        } catch (Exception e){
            throw new PaymentClientException("There was an error creating API request", e);
        }

        String result = getResult(uri, query);

        return new PayResponse(result);
    }

    private Process3DsResponse finish3Ds(Process3DsRequest request) throws PaymentClientException {
        Map<String,String> query = new LinkedHashMap<>();
        query.put("MerchantId", String.valueOf(request.getMerchantId()));
        query.put("TransactionId", String.valueOf(request.getTransactionId()));
        query.put("PaRes", request.getPaRes());
        query.put("PD", request.getPd());

        Map<String,String> signature = new LinkedHashMap<>(query);
        signature.put("PrivateSecurityKey", request.getPrivateSecurityKey());

        String secureParams = PayOnlineUtils.createQueryString(signature);
        String securityKey = PayOnlineUtils.getMD5Hash(secureParams);
        query.put("SecurityKey", securityKey);

        if (!PayOnlineUtils.stringIsNullOrWhiteSpace(request.getCustomData())) {
            Map<String, String> customData = PayOnlineUtils.parseQueryString(request.getCustomData());
            query.putAll(customData);
        }

        StringBuilder url = new StringBuilder();
        url.append(this.settings.getHost());
        url.append("payment/transaction/auth/3ds/");

        URI uri;
        try {
            uri = new URI(url.toString());
        } catch (Exception e){
            throw new PaymentClientException("There was an error creating API request", e);
        }

        String result = getResult(uri, query);

        return new Process3DsResponse(result);
    }

    private String getResult(URI uri, Map<String, String> query) throws PaymentClientException {
        try {
            return PayOnlineUtils.callApi(uri.toString(), PayOnlineUtils.createQueryString(query));
        } catch (IOException e) {
            e.printStackTrace();
            throw new PaymentClientException("There was an error calling API service", e);
        }
    }
}
