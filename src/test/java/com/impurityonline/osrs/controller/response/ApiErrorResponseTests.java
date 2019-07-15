package com.impurityonline.osrs.controller.response;

import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author tmk2003
 */
class ApiErrorResponseTests extends AbstractTest {

    @Test
    @DisplayName("When building with null status, throw null pointer")
    void status_param() {
        assertThrows(NullPointerException.class, () -> new ApiErrorResponse(null, "", new Exception()));
    }

    @Test
    @DisplayName("When building with null message, throw null pointer")
    void message_param() {
        assertThrows(NullPointerException.class, () -> new ApiErrorResponse(OK, null, new Exception()));
    }

    @Test
    @DisplayName("When building with null throwable, throw null pointer")
    void throwable_param() {
        assertThrows(NullPointerException.class, () -> new ApiErrorResponse(OK, "", null));
    }
}
