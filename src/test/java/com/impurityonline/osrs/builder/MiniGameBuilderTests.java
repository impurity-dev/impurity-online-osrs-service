package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiMiniGame;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.MiniGame;
import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MiniGameBuilderTests extends AbstractTest {

    private static ApiPlayerResponse apiPlayerResponse;

    @BeforeAll
    public static void setup() throws Exception {
        apiPlayerResponse = getValidApiPlayerResponse();
    }

    @Test
    @DisplayName("When player api response is null, throw null pointer")
    void minigameBuilder_nullResponse_throwsNullpointer() {
        assertThrows(NullPointerException.class, () -> MiniGameBuilder.buildMiniGames(null));
    }

    @Test
    @DisplayName("When player api response is valid, build the mini games")
    void minigameBuild_buildsBountyHunter() {
        ApiMiniGame expected = apiPlayerResponse.getBountyHunter();
        MiniGame actual = MiniGameBuilder.buildMiniGames(apiPlayerResponse).getBountyHunter();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the bounty hunter rogues")
    void minigameBuild_buildsBountyHunterRogues() {
        ApiMiniGame expected = apiPlayerResponse.getBountyHunterRogues();
        MiniGame actual = MiniGameBuilder.buildMiniGames(apiPlayerResponse).getBountyHunterRogues();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the mini games")
    void minigameBuild_buildsLastManStanding() {
        ApiMiniGame expected = apiPlayerResponse.getLastManStanding();
        MiniGame actual = MiniGameBuilder.buildMiniGames(apiPlayerResponse).getLastManStanding();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }
}
