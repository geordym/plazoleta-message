package com.plazoleta.messaging.infraestructure.exceptionhandler;


import com.plazoleta.messaging.application.dto.response.ErrorGenericResponseDto;
import com.plazoleta.messaging.domain.exception.ExternalConnectionException;
import com.plazoleta.messaging.domain.exception.InvalidPhoneNumberException;
import com.plazoleta.messaging.domain.exception.MessageTooLongException;
import com.plazoleta.messaging.domain.exception.MessageTooShortException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DomainExceptionHandler {

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<ErrorGenericResponseDto> handleInvalidPhoneNumberException(InvalidPhoneNumberException ex){
        ErrorGenericResponseDto errorGenericResponseDto = new ErrorGenericResponseDto(ex.getError(), ex.getMessage(), ex.getTimestamps());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorGenericResponseDto);
    }


    @ExceptionHandler(MessageTooLongException.class)
    public ResponseEntity<ErrorGenericResponseDto> handleMessageTooLongException(MessageTooLongException ex){
        ErrorGenericResponseDto errorGenericResponseDto = new ErrorGenericResponseDto(ex.getError(), ex.getMessage(), ex.getTimestamps());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorGenericResponseDto);
    }

    @ExceptionHandler(MessageTooShortException.class)
    public ResponseEntity<ErrorGenericResponseDto> handleMessageTooShortException(MessageTooShortException ex){
        ErrorGenericResponseDto errorGenericResponseDto = new ErrorGenericResponseDto(ex.getError(), ex.getMessage(), ex.getTimestamps());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorGenericResponseDto);
    }

    @ExceptionHandler(ExternalConnectionException.class)
    public ResponseEntity<ErrorGenericResponseDto> handleExternalConnectionException(ExternalConnectionException ex){
        ErrorGenericResponseDto errorGenericResponseDto = new ErrorGenericResponseDto(ex.getError(), ex.getMessage(), ex.getTimestamps());
        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT)
                .body(errorGenericResponseDto);
    }

}
