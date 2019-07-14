package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidOsrsPlayerClientResponse;
import static com.impurityonline.osrs.builder.PlayerBuilder.buildPlayer;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerBuilderTests extends AbstractTest {

    @Test
    @DisplayName("When player built, name is correct")
    void osrsPlayer_name() {
        String name = "apples";
        assertEquals(name, buildPlayer(name, "", getValidOsrsPlayerClientResponse()).getName());
    }

    @Test
    @DisplayName("When player built, type is correct")
    void osrsPlayer_type() {
        String type = "apples";
        assertEquals(type, buildPlayer("", type, getValidOsrsPlayerClientResponse()).getType());
    }

    @Test
    @DisplayName("When player hi scores null, throw null pointer")
    void osrsPlayer_null_playerHiScores() {
        assertThrows(NullPointerException.class, () -> buildPlayer("", "", null));
    }

    @Test
    @DisplayName("When player type null, throw null pointer")
    void osrsPlayer_null_type() {
        assertThrows(NullPointerException.class, () -> buildPlayer("", null, null));
    }

    @Test
    @DisplayName("When player name null, throw null pointer")
    void osrsPlayer_null_name() {
        assertThrows(NullPointerException.class, () -> buildPlayer(null, "", ""));
    }

    @Test
    @DisplayName("When player hiscores invalid, throw illegal argument")
    void osrsPlayer_hiscores_invalidLength() {
        assertThrows(IllegalArgumentException.class, () -> buildPlayer("", "", "123\n123\n123"));
    }

}
