package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author impurity
 */
class ApiClueScrollTests extends AbstractTest {

    @Test
    @DisplayName("When the api clue scroll has null hiscores, throw null pointer")
    void apiClueScrolls_nullHiScores_nullPointer() {
        assertThrows(NullPointerException.class, () -> new ApiClueScroll(null));
    }

    @Test
    @DisplayName("When the api clue scroll has empty hiscores, throw apiPlayerResponseException")
    void apiClueScrolls_emptyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiClueScroll(""));
    }

    @Test
    @DisplayName("When the api clue scroll has too few hiscores, throw apiPlayerResponseException")
    void apiClueScrolls_tooFewHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiClueScroll("1,"));
    }

    @Test
    @DisplayName("When the api clue scroll has too many hiscores, throw apiPlayerResponseException")
    void apiClueScrolls_tooManyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiClueScroll("1,1,1"));
    }

    @Test
    @DisplayName("When the api clue scroll has too many hiscores, throw apiPlayerResponseException")
    void apiClueScrolls_invalidHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiClueScroll("a,1"));
    }

    @Test
    @DisplayName("When the api clue scroll has valid hiscores, create and store rank")
    void apiClueScrolls_validHiScores_rank() throws Exception {
        ApiClueScroll clueScroll = new ApiClueScroll("1,2");
        assertEquals(clueScroll.getRank(), (Long) 1L);
    }

    @Test
    @DisplayName("When the api clue scroll has valid hiscores, create and store score")
    void apiClueScrolls_validHiScores_score() throws Exception {
        ApiClueScroll clueScroll = new ApiClueScroll("1,2");
        assertEquals(clueScroll.getScore(), (Long) 2L);
    }
}
