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

    @Test
    @DisplayName("When the api clue scroll equals is self, return true")
    void apiClueScrolls_validHiScores_equalsSelf() throws Exception {
        ApiClueScroll clueScroll = new ApiClueScroll("1,2");
        assertTrue(clueScroll.equals(clueScroll));
    }

    @Test
    @DisplayName("When the api clue scroll equals has different rank, return false")
    void apiSkills_validHiScores_equalsDifferentRank() throws Exception {
        ApiClueScroll clueScroll1 = new ApiClueScroll("1,2");
        ApiClueScroll clueScroll2 = new ApiClueScroll("9,2");
        assertFalse(clueScroll1.equals(clueScroll2));
    }

    @Test
    @DisplayName("When the api clue scroll equals has different score, return false")
    void apiSkills_validHiScores_equalsDifferentScore() throws Exception {
        ApiClueScroll clueScroll1 = new ApiClueScroll("1,2");
        ApiClueScroll clueScroll2 = new ApiClueScroll("1,9");
        assertFalse(clueScroll1.equals(clueScroll2));
    }

    @Test
    @DisplayName("When the api clue scroll equals is same values, return true")
    void apiClueScrolls_validHiScores_equalsSameValues() throws Exception {
        ApiClueScroll clueScroll1 = new ApiClueScroll("1,2");
        ApiClueScroll clueScroll2 = new ApiClueScroll("1,2");
        assertTrue(clueScroll1.equals(clueScroll2));
    }

    @Test
    @DisplayName("When the api clue scroll equals is wrong class, return false")
    void apiClueScrolls_validHiScores_equalsDifferentClass() throws Exception {
        ApiClueScroll clueScroll = new ApiClueScroll("1,2");
        assertFalse(clueScroll.equals(""));
    }

    @Test
    @DisplayName("When the api clue scroll equals is null, return false")
    void apiClueScrolls_validHiScores_equalsNull() throws Exception {
        ApiClueScroll clueScroll = new ApiClueScroll("1,2");
        assertFalse(clueScroll.equals(null));
    }

    @Test
    @DisplayName("When the api clue scroll hashcode, return proper hashcode")
    void apiClueScrolls_hashCode() throws Exception {
        ApiClueScroll clueScroll = new ApiClueScroll("1,2");
        final int prime = 23;
        int hashCode = 1;
        hashCode = prime * hashCode + clueScroll.getRank().hashCode();
        hashCode = prime * hashCode + clueScroll.getScore().hashCode();
        assertEquals(hashCode, clueScroll.hashCode());
    }
}
