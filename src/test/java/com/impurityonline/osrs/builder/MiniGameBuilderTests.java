package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static com.impurityonline.osrs.utils.OsrsFactory.getInvalidMinigameHiscores;
import static com.impurityonline.osrs.builder.OsrsMiniGameBuilder.buildMiniGames;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MiniGameBuilderTests extends AbstractTest {

    @Test
    @DisplayName("When minigames hiscore is null, throw null pointer")
    void osrsMiniGames_null_hiscores() {
        assertThrows(NullPointerException.class, () -> buildMiniGames(null));
    }

    @Test
    @DisplayName("When minigames hiscore is invalid, throw illegal argument")
    void osrsMiniGames_invalid_hiscores() {
        assertThrows(IllegalArgumentException.class, () -> buildMiniGames(new String[0]));
    }

    @Test
    @DisplayName("When minigames hiscore is invalid, throw illegal argument")
    void osrsMiniGames_invalid_minigame() {
        assertThrows(IllegalArgumentException.class, () -> buildMiniGames(getInvalidMinigameHiscores().split("\\n")));
    }
}
