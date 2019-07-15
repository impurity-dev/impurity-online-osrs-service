package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.client.response.player.ApiSkill;
import com.impurityonline.osrs.domain.player.Skill;
import com.impurityonline.osrs.domain.player.Skills;
import com.impurityonline.osrs.enums.OsrsHiScore;
import lombok.NonNull;

import static java.util.Arrays.copyOfRange;

/**
 * @author impurity
 */
public class SkillsBuilder {

    private SkillsBuilder() {}

    public static Skills buildSkills(@NonNull ApiPlayerResponse apiPlayerResponse) {
        Skills skills = new Skills();
        skills.setOverall(buildSkill(apiPlayerResponse.getOverall()));
        skills.setAttack(buildSkill(apiPlayerResponse.getAttack()));
        skills.setDefence(buildSkill(apiPlayerResponse.getDefence()));
        skills.setStrength(buildSkill(apiPlayerResponse.getStrength()));
        skills.setHitpoints(buildSkill(apiPlayerResponse.getHitpoints()));
        skills.setRanged(buildSkill(apiPlayerResponse.getRanged()));
        skills.setPrayer(buildSkill(apiPlayerResponse.getPrayer()));
        skills.setMagic(buildSkill(apiPlayerResponse.getMagic()));
        skills.setCooking(buildSkill(apiPlayerResponse.getCooking()));
        skills.setWoodcutting(buildSkill(apiPlayerResponse.getWoodcutting()));
        skills.setFletching(buildSkill(apiPlayerResponse.getFletching()));
        skills.setFishing(buildSkill(apiPlayerResponse.getFishing()));
        skills.setFiremaking(buildSkill(apiPlayerResponse.getFiremaking()));
        skills.setCrafting(buildSkill(apiPlayerResponse.getCrafting()));
        skills.setSmithing(buildSkill(apiPlayerResponse.getSmithing()));
        skills.setMining(buildSkill(apiPlayerResponse.getMining()));
        skills.setHerblore(buildSkill(apiPlayerResponse.getHerblore()));
        skills.setAgility(buildSkill(apiPlayerResponse.getAgility()));
        skills.setThieving(buildSkill(apiPlayerResponse.getThieving()));
        skills.setSlayer(buildSkill(apiPlayerResponse.getSlayer()));
        skills.setFarming(buildSkill(apiPlayerResponse.getFarming()));
        skills.setRunecrafting(buildSkill(apiPlayerResponse.getRunecrafting()));
        skills.setHunter(buildSkill(apiPlayerResponse.getHunter()));
        skills.setConstruction(buildSkill(apiPlayerResponse.getContruction()));
        return skills;
    }

    private static Skill buildSkill(@NonNull ApiSkill apiSkill) {
        Skill skill = new Skill();
        skill.setRank(apiSkill.getRank());
        skill.setLevel(apiSkill.getLevel());
        skill.setExperience(apiSkill.getExperience());
        return skill;
    }
}
