package ru.payonline.sdk;

public final class PaymentClientException extends Exception {

    public PaymentClientException(){
        super();
    }

    public PaymentClientException(String message){
        super(message);
    }

    public PaymentClientException(String message, Exception e){
        super(message, e);
    }
}
