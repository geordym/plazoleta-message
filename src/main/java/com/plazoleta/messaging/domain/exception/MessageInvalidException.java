package com.plazoleta.messaging.domain.exception;

import com.plazoleta.messaging.domain.util.ExceptionConstants;

import java.time.LocalDateTime;

public class MessageInvalidException extends ErrorException{
    public MessageInvalidException() {
        super(ExceptionConstants.MESSAGE_INVALID_ERROR, ExceptionConstants.MESSAGE_INVALID_MESSAGE, LocalDateTime.now().toString());
    }
}
