package com.plazoleta.messaging.domain.exception;

import com.plazoleta.messaging.domain.util.ExceptionConstants;

import java.time.LocalDateTime;

public class MessageTooShortException extends ErrorException{


    public MessageTooShortException() {
        super(ExceptionConstants.MESSAGE_TOO_SHORT_ERROR, ExceptionConstants.MESSAGE_TOO_SHORT_MESSAGE, LocalDateTime.now().toString());
    }
}
