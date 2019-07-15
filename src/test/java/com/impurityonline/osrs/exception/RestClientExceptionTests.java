package com.impurityonline.osrs.exception;

import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author tmk2003
 */
class RestClientExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The rest template client exception stores message properly")
    void captures_message() {
        String testMessage = "apples";
        assertEquals(new RestTemplateClientException(testMessage, HttpStatus.SERVICE_UNAVAILABLE, new Exception()).getMessage(), testMessage);
    }

    @Test
    @DisplayName("The rest template client exception stores message properly")
    void captures_throwable() {
        Exception testException = new Exception();
        assertEquals(new RestTemplateClientException("apples", HttpStatus.SERVICE_UNAVAILABLE, testException).getCause(), testException);
    }

    @Test
    @DisplayName("The rest template client exception stores message properly")
    void captures_status() {
        HttpStatus testStatus = HttpStatus.ACCEPTED;
        assertEquals(new RestTemplateClientException("apples",testStatus, new Exception()).getStatus(), testStatus);
    }
}

