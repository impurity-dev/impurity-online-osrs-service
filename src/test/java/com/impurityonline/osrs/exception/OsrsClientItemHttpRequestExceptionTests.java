package com.impurityonline.osrs.exception;

import com.impurityonline.osrs.test.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
class OsrsClientItemHttpRequestExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The osrs item request exception stores message properly")
    void captures_message() {
        String testMessage = "apples";
        assertEquals(new OsrsClientItemHttpRequestException(testMessage, HttpStatus.SERVICE_UNAVAILABLE, new Exception()).getMessage(), testMessage);
    }

    @Test
    @DisplayName("The osrs item request exception stores message properly")
    void captures_throwable() {
        Exception testException = new Exception();
        assertEquals(new OsrsClientItemHttpRequestException("apples", HttpStatus.SERVICE_UNAVAILABLE, testException).getCause(), testException);
    }

    @Test
    @DisplayName("The osrs item request exception stores message properly")
    void captures_status() {
        HttpStatus testStatus = HttpStatus.ACCEPTED;
        assertEquals(new OsrsClientItemHttpRequestException("apples",testStatus, new Exception()).getStatus(), testStatus);
    }
}

