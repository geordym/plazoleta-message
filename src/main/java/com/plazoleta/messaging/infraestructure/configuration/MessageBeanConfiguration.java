package com.plazoleta.messaging.infraestructure.configuration;

import com.plazoleta.messaging.application.handler.IMessageHandler;
import com.plazoleta.messaging.application.handler.impl.MessageHandlerImpl;
import com.plazoleta.messaging.domain.api.IMessageServicePort;
import com.plazoleta.messaging.domain.spi.ISMSProviderPort;
import com.plazoleta.messaging.domain.usecase.MessageUseCase;
import com.plazoleta.messaging.infraestructure.out.twilio.adapter.TwilioSmsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBeanConfiguration {

    @Bean
    public IMessageHandler messageHandler(){
        return new MessageHandlerImpl(messageServicePort());
    }

    @Bean
    public IMessageServicePort messageServicePort(){
        return new MessageUseCase(smsProviderPort());
    }

    @Bean
    public ISMSProviderPort smsProviderPort(){
        return new TwilioSmsAdapter();
    }

}
