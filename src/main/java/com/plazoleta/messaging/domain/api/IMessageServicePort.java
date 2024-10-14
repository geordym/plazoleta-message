package com.plazoleta.messaging.domain.api;


public interface IMessageServicePort {

    void sendMessageSMS(String phoneNumber, String message);
}
