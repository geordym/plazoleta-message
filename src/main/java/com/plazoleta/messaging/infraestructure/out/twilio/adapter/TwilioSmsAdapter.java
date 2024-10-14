package com.plazoleta.messaging.infraestructure.out.twilio.adapter;

import com.plazoleta.messaging.domain.exception.ExternalConnectionException;
import com.plazoleta.messaging.domain.spi.ISMSProviderPort;
import lombok.RequiredArgsConstructor;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class TwilioSmsAdapter implements ISMSProviderPort {

    @Value("${TWILIO_ACCOUNT_SID}")
    public String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    public String AUTH_TOKEN;

    @Value("${TWILIO_FROM_NUMBER}")
    public String FROM_NUMBER;

    @Override
    public void sendSMS(String phoneNumber, String messageContent) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try{
            Message.creator(new PhoneNumber(phoneNumber),
                            new PhoneNumber(FROM_NUMBER),
                            messageContent)
                    .create();
        }catch (Exception e){
            throw new ExternalConnectionException();
        }


    }


}
