package com.impurityonline.osrs.exception;

import com.impurityonline.osrs.test.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
class ApiPlayerResponseExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The osrs player response exception stores message properly")
    void captures_message() {
        String testMessage = "apples";
        assertEquals(new ApiPlayerResponseException(testMessage).getMessage(), testMessage);
    }
}

