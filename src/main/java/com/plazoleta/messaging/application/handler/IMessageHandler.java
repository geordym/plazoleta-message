package com.plazoleta.messaging.application.handler;


import com.plazoleta.messaging.application.dto.request.MessageRequestDto;

public interface IMessageHandler {

    void communicateOrderReadySMS(MessageRequestDto messageRequestDto);

}
