package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import com.impurityonline.osrs.test.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
class ApiMiniGameResponseTests extends AbstractTest {

    @Test
    @DisplayName("When the api miniGame has null hiscores, throw null pointer")
    void apiMiniGames_nullHiScores_nullPointer() {
        assertThrows(NullPointerException.class, () -> new ApiMiniGameResponse(null));
    }

    @Test
    @DisplayName("When the api miniGame has empty hiscores, throw apiPlayerResponseException")
    void apiMiniGames_emptyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGameResponse(""));
    }

    @Test
    @DisplayName("When the api miniGame has too few hiscores, throw apiPlayerResponseException")
    void apiMiniGames_tooFewHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGameResponse("1,"));
    }

    @Test
    @DisplayName("When the api miniGame has too many hiscores, throw apiPlayerResponseException")
    void apiMiniGames_tooManyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGameResponse("1,1,1"));
    }

    @Test
    @DisplayName("When the api miniGame has too many hiscores, throw apiPlayerResponseException")
    void apiMiniGames_invalidHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGameResponse("a,1"));
    }

    @Test
    @DisplayName("When the api miniGame has valid hiscores, create and store rank")
    void apiMiniGames_validHiScores_rank() throws Exception {
        ApiMiniGameResponse miniGame = new ApiMiniGameResponse("1,2");
        assertEquals(miniGame.getRank(), (Long) 1L);
    }

    @Test
    @DisplayName("When the api miniGame has valid hiscores, create and store score")
    void apiMiniGames_validHiScores_score() throws Exception {
        ApiMiniGameResponse miniGame = new ApiMiniGameResponse("1,2");
        assertEquals(miniGame.getScore(), (Long) 2L);
    }
}
