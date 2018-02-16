package ru.payonline.sdk;

import java.net.URI;

public interface IPaymentSetting {

    String getHost();
    String getLanguage();
    void setHost(URI value);
    void setLanguage(String value);
}
