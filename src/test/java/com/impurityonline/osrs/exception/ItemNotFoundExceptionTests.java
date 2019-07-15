package com.impurityonline.osrs.exception;

import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
class ItemNotFoundExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The osrs item not found exception stores message properly")
    void captures_message() {
        String testMessage = "apples";
        assertEquals(new ItemNotFoundException(testMessage).getMessage(), testMessage);
    }
}

