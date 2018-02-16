package ru.payonline.sdk;

import java.util.Map;

public class PayResponse {

    private long id;
    private String operation;
    private int code;
    private String result;
    private String status;
    private int errorCode;
    private String message;
    private String rebillAnchor;
    private String ipCountry;
    private String binCountry;
    private String specialConditions;
    private String paReq;
    private String pd;
    private String acsUrl;

    public long getId(){
        return this.id;
    }

    public String getOperation(){
        return this.operation;
    }

    public int getCode(){
        return this.code;
    }

    public String getResult(){
        return this.result;
    }

    public String getStatus(){
        return this.status;
    }

    public int getErrorCode(){
        return this.errorCode;
    }

    public String getMessage(){
        return this.message;
    }

    public String getRebillAnchor(){
        return this.rebillAnchor;
    }

    public String getIpCountry(){
        return this.ipCountry;
    }

    public String getBinCountry(){
        return this.binCountry;
    }

    public String getSpecialConditions(){
        return this.specialConditions;
    }

    public String getPaReq(){
        return this.paReq;
    }

    public String getPd(){
        return this.pd;
    }

    public String getAcsUrl(){
        return this.acsUrl;
    }

    public PayResponse(String v) {
        Map<String, String> map = PayOnlineUtils.parseQueryString(v);
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if (entry.getKey().equalsIgnoreCase("Id"))
                this.id = Long.parseLong(entry.getValue().trim());
            if (entry.getKey().equalsIgnoreCase("Operation"))
                this.operation = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("Code"))
                this.code = Integer.parseInt(entry.getValue().trim());
            if (entry.getKey().equalsIgnoreCase("Result"))
                this.result = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("Status"))
                this.status = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("errorCode"))
                this.errorCode = Integer.parseInt(entry.getValue().trim());
            if (entry.getKey().equalsIgnoreCase("Message"))
                this.message = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("rebillAnchor"))
                this.rebillAnchor = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("ipCountry"))
                this.ipCountry = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("binCountry"))
                this.binCountry = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("SpecialConditions"))
                this.specialConditions = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("PaReq"))
                this.paReq = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("PD"))
                this.pd = entry.getValue().trim();
            if (entry.getKey().equalsIgnoreCase("AcsUrl"))
                this.acsUrl = entry.getValue().trim();
        }
    }
}
