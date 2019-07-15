package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author impurity
 */
class ApiMiniGameTests extends AbstractTest {

    @Test
    @DisplayName("When the api miniGame has null hiscores, throw null pointer")
    void apiMiniGames_nullHiScores_nullPointer() {
        assertThrows(NullPointerException.class, () -> new ApiMiniGame(null));
    }

    @Test
    @DisplayName("When the api miniGame has empty hiscores, throw apiPlayerResponseException")
    void apiMiniGames_emptyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGame(""));
    }

    @Test
    @DisplayName("When the api miniGame has too few hiscores, throw apiPlayerResponseException")
    void apiMiniGames_tooFewHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGame("1,"));
    }

    @Test
    @DisplayName("When the api miniGame has too many hiscores, throw apiPlayerResponseException")
    void apiMiniGames_tooManyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGame("1,1,1"));
    }

    @Test
    @DisplayName("When the api miniGame has too many hiscores, throw apiPlayerResponseException")
    void apiMiniGames_invalidHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiMiniGame("a,1"));
    }

    @Test
    @DisplayName("When the api miniGame has valid hiscores, create and store rank")
    void apiMiniGames_validHiScores_rank() throws Exception {
        ApiMiniGame miniGame = new ApiMiniGame("1,2");
        assertEquals(miniGame.getRank(), (Long) 1L);
    }

    @Test
    @DisplayName("When the api miniGame has valid hiscores, create and store score")
    void apiMiniGames_validHiScores_score() throws Exception {
        ApiMiniGame miniGame = new ApiMiniGame("1,2");
        assertEquals(miniGame.getScore(), (Long) 2L);
    }

    @Test
    @DisplayName("When the api miniGame equals is self, return true")
    void apiMiniGames_validHiScores_equalsSelf() throws Exception {
        ApiMiniGame miniGame = new ApiMiniGame("1,2");
        assertTrue(miniGame.equals(miniGame));
    }

    @Test
    @DisplayName("When the api miniGame equals is same values, return true")
    void apiMiniGames_validHiScores_equalsSameValues() throws Exception {
        ApiMiniGame miniGame1 = new ApiMiniGame("1,2");
        ApiMiniGame miniGame2 = new ApiMiniGame("1,2");
        assertTrue(miniGame1.equals(miniGame2));
    }

    @Test
    @DisplayName("When the api miniGame equals is wrong class, return false")
    void apiMiniGames_validHiScores_equalsDifferentClass() throws Exception {
        ApiMiniGame miniGame = new ApiMiniGame("1,2");
        assertFalse(miniGame.equals(""));
    }

    @Test
    @DisplayName("When the api miniGame equals is null, return false")
    void apiMiniGames_validHiScores_equalsNull() throws Exception {
        ApiMiniGame miniGame = new ApiMiniGame("1,2");
        assertFalse(miniGame.equals(null));
    }
}
