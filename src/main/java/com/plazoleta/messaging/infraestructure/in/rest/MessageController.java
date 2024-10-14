package com.plazoleta.messaging.infraestructure.in.rest;


import com.plazoleta.messaging.application.dto.request.MessageRequestDto;
import com.plazoleta.messaging.application.handler.IMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

    private final IMessageHandler messageHandler;


    @PostMapping("/sms")
    public ResponseEntity<Void> communicateMessageSMS(@RequestBody MessageRequestDto messageRequestDto){
            messageHandler.communicateOrderReadySMS(messageRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
