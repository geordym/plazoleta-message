package com.plazoleta.messaging.domain.usecase;


import com.plazoleta.messaging.domain.exception.InvalidPhoneNumberException;
import com.plazoleta.messaging.domain.exception.MessageInvalidException;
import com.plazoleta.messaging.domain.exception.MessageTooLongException;
import com.plazoleta.messaging.domain.exception.MessageTooShortException;
import com.plazoleta.messaging.domain.spi.ISMSProviderPort;
import com.plazoleta.messaging.util.DataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static com.plazoleta.messaging.domain.util.Constants.MAX_MESSAGE_LENGTH;
import static com.plazoleta.messaging.domain.util.Constants.MIN_MESSAGE_LENGTH;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class MessageUseCaseTest {

    @Mock
    private ISMSProviderPort smsProviderPort;

    private MessageUseCase messageUseCase;

    @BeforeEach
    void setup(){
        messageUseCase = new MessageUseCase(smsProviderPort);
    }


    static Stream<String> invalidPhoneNumbers() {
        return Stream.of(
                "573026468094",    // Sin +
                "12345678901234",  // Más de 13 dígitos
                "+",                // Solo el símbolo +
                "+12345678901234", // Más de 13 dígitos con +
                "invalidPhone"     // No es numérico
        );
    }


    @ParameterizedTest
    @MethodSource("invalidPhoneNumbers")
    void testWhenPhoneNumberIsInvalidThrowsException(String invalidPhone){

        assertThrows(InvalidPhoneNumberException.class, () -> messageUseCase.sendMessageSMS(invalidPhone, ""));
    }

    @Test
    void testWhenMessageIsEmptyThrowsException(){
        String phoneNumber = DataProvider.getValidPhoneNumber();
        String message = "";

        assertThrows(MessageInvalidException.class, () -> messageUseCase.sendMessageSMS(phoneNumber, message));
    }

    @Test
    void testWhenPhoneNumberIsTooShortThrowsException(){
        String phoneNumber = DataProvider.getValidPhoneNumber();
        String message = "a".repeat(MIN_MESSAGE_LENGTH - 1);

        assertThrows(MessageTooShortException.class, () -> messageUseCase.sendMessageSMS(phoneNumber, message));
    }

    @Test
    void testWhenPhoneNumberIsTooLongThrowsException(){
        String phoneNumber = DataProvider.getValidPhoneNumber();
        String message = "a".repeat(MAX_MESSAGE_LENGTH + 1);

        assertThrows(MessageTooLongException.class, () -> messageUseCase.sendMessageSMS(phoneNumber, message));
    }




}
