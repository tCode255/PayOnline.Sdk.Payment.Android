package ru.payonline.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public final class PaymentLinkRequest {

    private int merchantId;
    private String orderId;
    private double amount;
    private String currency;
    private String validUntil;
    private String orderDescription;
    private String privateSecurityKey;
    private String email;
    private String returnUrl;
    private String failUrl;
    private String customData;

    public int getMerchantId(){ return this.merchantId; }

    public void setMerchantId(int value){ this.merchantId = value; }

    public String getOrderId(){ return this.orderId; }

    public void setOrderId(String value) { this.orderId = value; }

    public String getAmount(){ return String.format(Locale.US, "%.2f", this.amount); }

    public void setAmount(double value){ this.amount = value; }

    public String getCurrency(){ return this.currency; }

    public void setCurrency(String value) { this.currency = value; }

    public String getValidUntil(){ return this.validUntil; }

    public void setValidUntil(String value) { this.validUntil = value; }

    public String getOrderDescription(){ return this.orderDescription; }

    public void setOrderDescription(String value) { this.orderDescription = value; }

    public String getPrivateSecurityKey(){ return this.privateSecurityKey; }

    public void setPrivateSecurityKey(String value) { this.privateSecurityKey = value; }

    public String getEmail(){ return this.email; }

    public void setEmail(String value) { this.email = value; }

    public String getReturnUrl(){ return this.returnUrl; }

    public void setReturnUrl(String value) throws PaymentClientException {
        try {
            this.returnUrl = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new PaymentClientException("Can't encoding value of 'ReturnUrl' parameter", e);
        }
    }

    public String getFailUrl(){ return this.failUrl; }

    public void setFailUrl(String value) throws PaymentClientException {
        try {
            this.failUrl = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new PaymentClientException("Can't encoding value of 'FailUrl' parameter", e);
        }
    }

    public String getCustomData(){ return this.customData; }

    public void setCustomData(String value) { this.customData = value; }
}
