package ru.payonline.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public final class PayRequest {

    private final String ENCODING = "UTF-8";
    private int merchantId;
    private String orderId;
    private double amount;
    private String currency;
    private String orderDescription;
    private String privateSecurityKey;
    private String email;
    private String ip;
    private String cardHolderName;
    private String cardNumber;
    private String cardExpDate;
    private String cardCvv;
    private String country;
    private String city;
    private String address;
    private String state;
    private String zip;
    private String phone;
    private String issuer;
    private String customData;

    /* Gets */
    public int getMerchantId() {
        return this.merchantId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getAmount() {
        return String.format(Locale.US, "%.2f", this.amount);
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getOrderDescription() {
        return this.orderDescription;
    }

    public String getPrivateSecurityKey() {
        return this.privateSecurityKey;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIp() {
        return this.ip;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getCardExpDate() {
        return this.cardExpDate;
    }

    public String getCardCvv() {
        return this.cardCvv;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddress() {
        return this.address;
    }

    public String getZip() {
        return this.zip;
    }

    public String getState() {
        return this.state;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getCustom() {
        return this.customData;
    }

    /* Sets */
    public void setMerchantId(int value) {
        this.merchantId = value;
    }

    public void setOrderId(String value) {
        this.orderId = value;
    }

    public void setAmount(double value) {
        this.amount = value;
    }

    public void setCurrency(String value) {
        this.currency = value;
    }

    public void setOrderDescription(String value) {
        this.orderDescription = value;
    }

    public void setPrivateSecurityKey(String value) {
        this.privateSecurityKey = value;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public void setIp(String value) {
        this.ip = value;
    }

    public void setCardHolderName(String value) {
        this.cardHolderName = PayOnlineUtils.toUTF8(value);
    }

    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    public void setCardExpDate(String value) {
        this.cardExpDate = value;
    }

    public void setCardCvv(String value) {
        this.cardCvv = value;
    }

    public void setCountry(String value) {
        this.country = PayOnlineUtils.toUTF8(value);
    }

    public void setCity(String value) {
        this.city = PayOnlineUtils.toUTF8(value);
    }

    public void setAddress(String value) {
        this.address = PayOnlineUtils.toUTF8(value);
    }

    public void setZip(String value) {
        this.zip = PayOnlineUtils.toUTF8(value);
    }

    public void setState(String value) {
        this.state = PayOnlineUtils.toUTF8(value);
    }

    public void setPhone(String value) {
        try {
            this.phone = URLEncoder.encode(PayOnlineUtils.toUTF8(value), this.ENCODING);
        } catch (UnsupportedEncodingException e) {
            this.phone = null;
        }
    }

    public void setIssuer(String value) {
        this.issuer = PayOnlineUtils.toUTF8(value);
    }

    public void setCustom(String value) {
        this.customData = PayOnlineUtils.toUTF8(value);
    }
}
