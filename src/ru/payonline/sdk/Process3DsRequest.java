package ru.payonline.sdk;

public final class Process3DsRequest {

    private int merchantId;
    private long transactionId;
    private String paRes;
    private String pd;
    private String privateSecurityKey;
    private String customData;

    public int getMerchantId() { return this.merchantId; }

    public void setMerchantId(int value) { this.merchantId = value; }

    public long getTransactionId() { return this.transactionId; }

    public void setTransactionId(long value) { this.transactionId = value; }

    public String getPaRes() { return this.paRes; }

    public void setPares(String value) { this.paRes = value; }

    public String getPd() { return this.pd; }

    public void setPd(String value) { this.pd = value; }

    public String getPrivateSecurityKey() { return this.privateSecurityKey; }

    public void setPrivateSecurityKey(String value) { this.privateSecurityKey = value; }

    public String getCustomData() { return this.customData; }

    public void setCustomData(String value) { this.customData = value; }
}
