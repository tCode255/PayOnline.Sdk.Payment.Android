package ru.payonline.sdk;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public final class DefaultPaymentSetting implements IPaymentSetting {

    private URI host;
    private String language;

    public DefaultPaymentSetting() throws PaymentClientException {
        try {
            this.host = new URI("https://secure.payonlinesystem.com/");
        } catch (URISyntaxException e) {
            throw new PaymentClientException("Invalid value of 'host' parameter");
        }
        this.language = "ru";
    }

    public DefaultPaymentSetting(URI host) {
        this.host = host;
    }

    public DefaultPaymentSetting(String language) {
        this.language = language;
    }

    public DefaultPaymentSetting(URI host, String language) {
        this.host = host;
        this.language = language;
    }

    @Override
    public String getHost() {
        return this.host.toString();
    }

    @Override
    public String getLanguage() {
        return this.language.toLowerCase(Locale.getDefault());
    }

    @Override
    public void setHost(URI value) {
        this.host = value;
    }

    @Override
    public void setLanguage(String value) {
        this.language = value;
    }
}
