package com.plazoleta.messaging.application.handler.impl;

import com.plazoleta.messaging.application.dto.request.MessageRequestDto;
import com.plazoleta.messaging.application.handler.IMessageHandler;
import com.plazoleta.messaging.domain.api.IMessageServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageHandlerImpl implements IMessageHandler {

    private final IMessageServicePort messageServicePort;

    @Override
    public void communicateOrderReadySMS(MessageRequestDto messageRequestDto) {
        messageServicePort.sendMessageSMS(messageRequestDto.getPhoneNumber(),
                messageRequestDto.getMessage());
    }



}
