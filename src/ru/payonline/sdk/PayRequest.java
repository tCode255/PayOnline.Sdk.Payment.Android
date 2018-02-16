package ru.payonline.sdk;

import java.util.Locale;

public final class PayRequest {

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

    public int getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(int value) {
        this.merchantId = value;
    }

    public String getOrderId() { return this.orderId; }

    public void setOrderId(String value) {
        this.orderId = value;
    }

    public String getAmount() {
        return String.format(Locale.US, "%.2f", this.amount);
    }

    public void setAmount(double value) {
        this.amount = value;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String value) {
        this.currency = value;
    }

    public String getOrderDescription() {
        return this.orderDescription;
    }

    public void setOrderDescription(String value) { this.orderDescription = value; }

    public String getPrivateSecurityKey() {
        return this.privateSecurityKey;
    }

    public void setPrivateSecurityKey(String value) {
        this.privateSecurityKey = value;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String value) {
        this.ip = value;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public void setCardHolderName(String value) { this.cardHolderName = value; }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    public String getCardExpDate() {
        return this.cardExpDate;
    }

    public void setCardExpDate(String value) {
        this.cardExpDate = value;
    }

    public String getCardCvv() {
        return this.cardCvv;
    }

    public void setCardCvv(String value) {
        this.cardCvv = value;
    }

    public String getCountry() { return this.country; }

    public void setCountry(String value) { this.country = value; }

    public String getCity() {
        return this.city;
    }

    public void setCity(String value) { this.city = value; }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String value) { this.address = value; }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String value) { this.zip = value; }

    public String getState() {
        return this.state;
    }

    public void setState(String value) { this.state = value; }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String value) { this.phone = value; }

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String value) { this.issuer = value; }

    public String getCustom() {
        return this.customData;
    }

    public void setCustom(String value) { this.customData = value; }
}
