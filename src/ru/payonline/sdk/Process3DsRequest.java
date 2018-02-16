package ru.payonline.sdk;

public final class Process3DsRequest {

    private int merchantId;
    private long transactionId;
    private String paRes;
    private String pd;
    private String privateSecurityKey;
    private String customData;

    /* Gets */
    public int getMerchantId() {
        return this.merchantId;
    }

    public long getTransactionId() {
        return this.transactionId;
    }

    public String getPaRes() {
        return this.paRes;
    }

    public String getPd() {
        return this.pd;
    }

    public String getPrivateSecurityKey() {
        return this.privateSecurityKey;
    }

    public String getCustomData() {
        return this.customData;
    }

    /* Sets */
    public void setMerchantId(int value) {
        this.merchantId = value;
    }

    public void setTransactionId(long value) {
        this.transactionId = value;
    }

    public void setPares(String value) {
        this.paRes = value;
    }

    public void setPd(String value) {
        this.pd = value;
    }

    public void setPrivateSecurityKey(String value) {
        this.privateSecurityKey = value;
    }

    public void setCustomData(String value) {
        this.customData = value;
    }
}
