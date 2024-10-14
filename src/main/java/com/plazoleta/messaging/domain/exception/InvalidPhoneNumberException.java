package com.plazoleta.messaging.domain.exception;


import com.plazoleta.messaging.domain.util.ExceptionConstants;

import java.time.LocalDateTime;

public class InvalidPhoneNumberException extends ErrorException{

    public InvalidPhoneNumberException() {
        super(ExceptionConstants.PHONE_NUMBER_ERROR, ExceptionConstants.PHONE_NUMBER_MESSAGE, LocalDateTime.now().toString());
    }

}
