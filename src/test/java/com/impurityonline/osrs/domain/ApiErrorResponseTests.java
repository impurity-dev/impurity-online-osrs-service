package com.impurityonline.osrs.domain;

import com.impurityonline.osrs.controller.response.ApiErrorResponse;
import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author tmk2003
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
