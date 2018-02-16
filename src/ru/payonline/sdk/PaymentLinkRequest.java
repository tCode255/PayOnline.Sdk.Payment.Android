package ru.payonline.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public final class PaymentLinkRequest {

    private final String ENCODING = "UTF-8";
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

    /* Gets */
    public int getMerchantId(){
        return this.merchantId;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public String getAmount(){
        return String.format(Locale.US, "%.2f", this.amount);
    }

    public String getCurrency(){
        return this.currency;
    }

    public String getValidUntil(){
        return this.validUntil;
    }

    public String getOrderDescription(){
        return this.orderDescription;
    }

    public String getPrivateSecurityKey(){
        return this.privateSecurityKey;
    }

    public String getEmail(){
        return this.email;
    }

    public String getReturnUrl(){
        return this.returnUrl;
    }

    public String getFailUrl(){
        return this.failUrl;
    }

    public String getCustomData(){
        return this.customData;
    }

    /* Sets */
    public void setMerchantId(int value){
        this.merchantId = value;
    }

    public void setOrderId(String value){
        this.orderId = value;
    }

    public void setAmount(double value){
        this.amount = value;
    }

    public void setCurrency(String value){
        this.currency = value;
    }

    public void setValidUntil(String value){
        this.validUntil = value;
    }

    public void setOrderDescription(String value) {
        this.orderDescription = value;
    }

    public void setPrivateSecurityKey(String value){
        this.privateSecurityKey = value;
    }

    public void setEmail(String value){
        this.email = value;
    }

    public void setReturnUrl(String value){
        try {
            this.returnUrl = URLEncoder.encode(PayOnlineUtils.toUTF8(value), this.ENCODING);
        } catch (UnsupportedEncodingException e) {
            this.returnUrl = null;
        }
    }

    public void setFailUrl(String value){
        try {
            this.failUrl = URLEncoder.encode(PayOnlineUtils.toUTF8(value), this.ENCODING);
        } catch (UnsupportedEncodingException e) {
            this.failUrl = null;
        }
    }

    public void setCustomData(String value){
        this.customData = value;
    }
}
