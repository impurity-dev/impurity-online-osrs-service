package com.impurityonline.osrs.exception;

import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
class PlayerNotFoundExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The osrs player not found exception stores message properly")
    void captures_message() {
        String testMessage = "apples";
        assertEquals(new PlayerNotFoundException(testMessage).getMessage(), testMessage);
    }
}

