package com.plazoleta.messaging.domain.exception;

import com.plazoleta.messaging.domain.util.ExceptionConstants;

import java.time.LocalDateTime;

public class MessageTooLongException extends ErrorException{

    public MessageTooLongException() {
        super(ExceptionConstants.MESSAGE_TOO_LONG_ERROR, ExceptionConstants.MESSAGE_TOO_LONG_MESSAGE, LocalDateTime.now().toString());
    }
}
