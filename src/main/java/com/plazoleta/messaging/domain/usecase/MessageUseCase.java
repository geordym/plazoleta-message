package com.plazoleta.messaging.domain.usecase;


import com.plazoleta.messaging.domain.api.IMessageServicePort;
import com.plazoleta.messaging.domain.exception.InvalidPhoneNumberException;
import com.plazoleta.messaging.domain.exception.MessageInvalidException;
import com.plazoleta.messaging.domain.exception.MessageTooLongException;
import com.plazoleta.messaging.domain.exception.MessageTooShortException;
import com.plazoleta.messaging.domain.spi.ISMSProviderPort;
import lombok.RequiredArgsConstructor;

import static com.plazoleta.messaging.domain.util.Constants.*;

@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {

    private final ISMSProviderPort smsProviderPort;

    @Override
    public void sendMessageSMS(String phoneNumber, String message) {
        validatePhoneNumber(phoneNumber);
        validateMessage(message);
        smsProviderPort.sendSMS(phoneNumber, message);
    }

    private void validateMessage(String message) {
        if (message.isEmpty()) {
            throw new MessageInvalidException();
        }

        if (message.isBlank()) {
            throw new MessageInvalidException();
        }

        if(message.length() < MIN_MESSAGE_LENGTH){
            throw new MessageTooShortException();
        }

        if(message.length() > MAX_MESSAGE_LENGTH){
            throw new MessageTooLongException();
        }
    }



    private void validatePhoneNumber(String phoneNumber){
        boolean hasInitialSymbol = phoneNumber.startsWith(NUMBER_PREFIX);
        if(!hasInitialSymbol){
            throw new InvalidPhoneNumberException();
        }

        boolean isValidPhoneNumber = phoneNumber.matches(PHONE_REGEX);
        if(!isValidPhoneNumber){
            throw new InvalidPhoneNumberException();
        }
    }

}
