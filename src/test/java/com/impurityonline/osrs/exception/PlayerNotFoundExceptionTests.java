package com.impurityonline.osrs.exception;

import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerNotFoundExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The osrs player not found exception stores message properly")
    void captures_message() {
        String testMessage = "apples";
        assertEquals(new PlayerNotFoundException(testMessage).getMessage(), testMessage);
    }
}

