package com.plazoleta.messaging.domain.spi;

public interface ISMSProviderPort {

    void sendSMS(String phoneNumber, String message);
}
