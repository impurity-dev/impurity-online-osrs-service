package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiMiniGame;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.MiniGame;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponse;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidMiniGame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author impurity
 */
class MiniGameBuilderTests extends AbstractTest {

    private static ApiPlayerResponse apiPlayerResponse;

    @BeforeAll
    public static void setup() throws Exception {
        apiPlayerResponse = getValidApiPlayerResponse();
    }

    @Test
    @DisplayName("When bounty hunter minigame is null, throw null pointer")
    void minigameBuilder_nullBountyHunter_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getBountyHunter()).thenReturn(null);
        when(playerResponse.getBountyHunterRogues()).thenReturn(getValidMiniGame());
        when(playerResponse.getLastManStanding()).thenReturn(getValidMiniGame());
        assertThrows(NullPointerException.class, () -> MiniGameBuilder.buildMiniGames(playerResponse));
    }

    @Test
    @DisplayName("When bounty hunter rogues minigame is null, throw null pointer")
    void minigameBuilder_nullBountyHunterRogues_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getBountyHunter()).thenReturn(getValidMiniGame());
        when(playerResponse.getBountyHunterRogues()).thenReturn(null);
        when(playerResponse.getLastManStanding()).thenReturn(getValidMiniGame());
        assertThrows(NullPointerException.class, () -> MiniGameBuilder.buildMiniGames(playerResponse));
    }

    @Test
    @DisplayName("When last man standing minigame is null, throw null pointer")
    void minigameBuilder_nullLastManStanding_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getBountyHunter()).thenReturn(getValidMiniGame());
        when(playerResponse.getBountyHunterRogues()).thenReturn(getValidMiniGame());
        when(playerResponse.getLastManStanding()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> MiniGameBuilder.buildMiniGames(playerResponse));
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
