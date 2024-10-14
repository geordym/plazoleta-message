package com.plazoleta.messaging.domain.util;

import static com.plazoleta.messaging.domain.util.Constants.MAX_MESSAGE_LENGTH;
import static com.plazoleta.messaging.domain.util.Constants.MIN_MESSAGE_LENGTH;

public class ExceptionConstants {

    public static final String PHONE_NUMBER_ERROR = "Invalid phone number.";
    public static final String PHONE_NUMBER_MESSAGE = "Please enter a valid phone number.";

    public static final String MESSAGE_INVALID_ERROR = "Invalid message.";
    public static final String MESSAGE_INVALID_MESSAGE = "Please enter a valid message.";

    public static final String MESSAGE_TOO_SHORT_ERROR = "Invalid message, too short.";
    public static final String MESSAGE_TOO_SHORT_MESSAGE = "The message is too short, the min length is: ." + MIN_MESSAGE_LENGTH ;

    public static final String MESSAGE_TOO_LONG_ERROR = "Invalid message, too long.";
    public static final String MESSAGE_TOO_LONG_MESSAGE = "The message is too long, the max length is:" + MAX_MESSAGE_LENGTH;

    public static final String EXTERNAL_CONNECTION_ERROR = "External connection error";
    public static final String EXTERNAL_CONNECTION_MESSAGE = "We cannot connect with an required external service please try more later.";

}
