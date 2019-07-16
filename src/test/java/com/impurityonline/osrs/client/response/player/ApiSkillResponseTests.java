package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
class ApiSkillResponseTests extends AbstractTest {

    @Test
    @DisplayName("When the api skills has null hiscores, throw null pointer")
    void apiSkills_nullHiScores_nullPointer() {
        assertThrows(NullPointerException.class, () -> new ApiSkillResponse(null));
    }

    @Test
    @DisplayName("When the api skills has empty hiscores, throw apiPlayerResponseException")
    void apiSkills_emptyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkillResponse(""));
    }

    @Test
    @DisplayName("When the api skills has too few hiscores, throw apiPlayerResponseException")
    void apiSkills_tooFewHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkillResponse("1,1"));
    }

    @Test
    @DisplayName("When the api skills has too many hiscores, throw apiPlayerResponseException")
    void apiSkills_tooManyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkillResponse("1,1,1,2"));
    }

    @Test
    @DisplayName("When the api skills has too many hiscores, throw apiPlayerResponseException")
    void apiSkills_invalidHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkillResponse("a,1,2"));
    }

    @Test
    @DisplayName("When the api skills has valid hiscores, create and store rank")
    void apiSkills_validHiScores_rank() throws Exception {
        ApiSkillResponse apiSkillResponse = new ApiSkillResponse("1,2,3");
        assertEquals(apiSkillResponse.getRank(), (Long) 1L);
    }

    @Test
    @DisplayName("When the api skills has valid hiscores, create and store level")
    void apiSkills_validHiScores_level() throws Exception {
        ApiSkillResponse apiSkillResponse = new ApiSkillResponse("1,2,3");
        assertEquals(apiSkillResponse.getLevel(), (Long) 2L);
    }

    @Test
    @DisplayName("When the api skills has valid hiscores, create and store experience")
    void apiSkills_validHiScores_experience() throws Exception {
        ApiSkillResponse apiSkillResponse = new ApiSkillResponse("1,2,3");
        assertEquals(apiSkillResponse.getExperience(), (Long) 3L);
    }
}
