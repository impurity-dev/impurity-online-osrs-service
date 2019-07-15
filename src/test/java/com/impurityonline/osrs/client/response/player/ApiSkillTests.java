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
class ApiSkillTests extends AbstractTest {

    @Test
    @DisplayName("When the api skills has null hiscores, throw null pointer")
    void apiSkills_nullHiScores_nullPointer() {
        assertThrows(NullPointerException.class, () -> new ApiSkill(null));
    }

    @Test
    @DisplayName("When the api skills has empty hiscores, throw apiPlayerResponseException")
    void apiSkills_emptyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkill(""));
    }

    @Test
    @DisplayName("When the api skills has too few hiscores, throw apiPlayerResponseException")
    void apiSkills_tooFewHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkill("1,1"));
    }

    @Test
    @DisplayName("When the api skills has too many hiscores, throw apiPlayerResponseException")
    void apiSkills_tooManyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkill("1,1,1,2"));
    }

    @Test
    @DisplayName("When the api skills has too many hiscores, throw apiPlayerResponseException")
    void apiSkills_invalidHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiSkill("a,1,2"));
    }

    @Test
    @DisplayName("When the api skills has valid hiscores, create and store rank")
    void apiSkills_validHiScores_rank() throws Exception {
        ApiSkill apiSkill = new ApiSkill("1,2,3");
        assertEquals(apiSkill.getRank(), (Long) 1L);
    }

    @Test
    @DisplayName("When the api skills has valid hiscores, create and store level")
    void apiSkills_validHiScores_level() throws Exception {
        ApiSkill apiSkill = new ApiSkill("1,2,3");
        assertEquals(apiSkill.getLevel(), (Long) 2L);
    }

    @Test
    @DisplayName("When the api skills has valid hiscores, create and store experience")
    void apiSkills_validHiScores_experience() throws Exception {
        ApiSkill apiSkill = new ApiSkill("1,2,3");
        assertEquals(apiSkill.getExperience(), (Long) 3L);
    }

    @Test
    @DisplayName("When the api skills equals is self, return true")
    void apiSkills_validHiScores_equalsSelf() throws Exception {
        ApiSkill skill = new ApiSkill("1,2,3");
        assertTrue(skill.equals(skill));
    }

    @Test
    @DisplayName("When the api skills equals is same values, return true")
    void apiSkills_validHiScores_equalsSameValues() throws Exception {
        ApiSkill skill1 = new ApiSkill("1,2,3");
        ApiSkill skill2 = new ApiSkill("9,2,3");
        assertFalse(skill1.equals(skill2));
    }

    @Test
    @DisplayName("When the api skills equals has different rank, return false")
    void apiSkills_validHiScores_equalsDifferentLevel() throws Exception {
        ApiSkill skill1 = new ApiSkill("1,2,3");
        ApiSkill skill2 = new ApiSkill("1,9,3");
        assertFalse(skill1.equals(skill2));
    }

    @Test
    @DisplayName("When the api skills equals has different rank, return false")
    void apiSkills_validHiScores_equalsDifferentExperience() throws Exception {
        ApiSkill skill1 = new ApiSkill("1,2,3");
        ApiSkill skill2 = new ApiSkill("1,2,9");
        assertFalse(skill1.equals(skill2));
    }

    @Test
    @DisplayName("When the api skills equals has different rank, return false")
    void apiSkills_validHiScores_equalsDifferentRank() throws Exception {
        ApiSkill skill1 = new ApiSkill("1,2,3");
        ApiSkill skill2 = new ApiSkill("1,2,3");
        assertTrue(skill1.equals(skill2));
    }

    @Test
    @DisplayName("When the api skills equals is wrong class, return false")
    void apiSkills_validHiScores_equalsDifferentClass() throws Exception {
        ApiSkill skill = new ApiSkill("1,2,3");
        assertFalse(skill.equals(""));
    }

    @Test
    @DisplayName("When the api skills equals is null, return false")
    void apiSkills_validHiScores_equalsNull() throws Exception {
        ApiSkill skill = new ApiSkill("1,2,3");
        assertFalse(skill.equals(null));
    }

    @Test
    @DisplayName("When the api skills hashcode, return proper hashcode")
    void apiSkills_hashCode() throws Exception {
        ApiSkill skill = new ApiSkill("1,2,3");
        final int prime = 29;
        int hashCode = 1;
        hashCode = prime * hashCode + skill.getRank().hashCode();
        hashCode = prime * hashCode + skill.getLevel().hashCode();
        hashCode = prime * hashCode + skill.getExperience().hashCode();
        assertEquals(hashCode, skill.hashCode());
    }
}
