package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.enums.OsrsHiScore;
import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.impurityonline.osrs.enums.OsrsHiScore.*;

/**
 * Raw string returned back from
 *
 * @author impurity
 */
@Slf4j
@Getter
public class ApiPlayerResponse {
    private static final int HISCORE_TOTAL = 34;
    private final String[] hiscores;
    private final ApiSkill overall;
    private final ApiSkill attack;
    private final ApiSkill defence;
    private final ApiSkill strength;
    private final ApiSkill hitpoints;
    private final ApiSkill ranged;
    private final ApiSkill prayer;
    private final ApiSkill magic;
    private final ApiSkill cooking;
    private final ApiSkill woodcutting;
    private final ApiSkill fletching;
    private final ApiSkill fishing;
    private final ApiSkill firemaking;
    private final ApiSkill crafting;
    private final ApiSkill smithing;
    private final ApiSkill mining;
    private final ApiSkill herblore;
    private final ApiSkill agility;
    private final ApiSkill thieving;
    private final ApiSkill slayer;
    private final ApiSkill farming;
    private final ApiSkill runecrafting;
    private final ApiSkill hunter;
    private final ApiSkill construction;
    private final ApiMiniGame bountyHunter;
    private final ApiMiniGame bountyHunterRogues;
    private final ApiMiniGame lastManStanding;
    private final ApiClueScroll clueScrolls;
    private final ApiClueScroll easyClueScrolls;
    private final ApiClueScroll mediumClueScrolls;
    private final ApiClueScroll hardClueScrolls;
    private final ApiClueScroll eliteClueScrolls;
    private final ApiClueScroll masterClueScrolls;

    /**
     * Create api player response based off hiscores
     *
     * @param hiscores the api returned hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiPlayerResponse(@NonNull String hiscores) throws ApiPlayerResponseException {
        this.hiscores = hiscores.split("\\n");
        if (this.hiscores.length != HISCORE_TOTAL) {
            log.error("Not valid player hiscores count: hiscores={}", hiscores);
            throw new ApiPlayerResponseException("Invalid player hiscores length");
        }

        this.overall = new ApiSkill(getHiscore(OVERALL));
        this.attack = new ApiSkill(getHiscore(ATTACK));
        this.defence = new ApiSkill(getHiscore(DEFENCE));
        this.strength = new ApiSkill(getHiscore(STRENGTH));
        this.hitpoints = new ApiSkill(getHiscore(HITPOINTS));
        this.ranged = new ApiSkill(getHiscore(RANGED));
        this.prayer = new ApiSkill(getHiscore(PRAYER));
        this.magic = new ApiSkill(getHiscore(MAGIC));
        this.cooking = new ApiSkill(getHiscore(COOKING));
        this.woodcutting = new ApiSkill(getHiscore(WOODCUTTING));
        this.fletching = new ApiSkill(getHiscore(FLETCHING));
        this.fishing = new ApiSkill(getHiscore(FISHING));
        this.firemaking = new ApiSkill(getHiscore(FIREMAKING));
        this.crafting = new ApiSkill(getHiscore(CRAFTING));
        this.smithing = new ApiSkill(getHiscore(SMITHING));
        this.mining = new ApiSkill(getHiscore(MINING));
        this.herblore = new ApiSkill(getHiscore(HERBLORE));
        this.agility = new ApiSkill(getHiscore(AGILITY));
        this.thieving = new ApiSkill(getHiscore(THIEVING));
        this.slayer = new ApiSkill(getHiscore(SLAYER));
        this.farming = new ApiSkill(getHiscore(FARMING));
        this.runecrafting = new ApiSkill(getHiscore(RUNECRAFTING));
        this.hunter = new ApiSkill(getHiscore(HUNTER));
        this.construction = new ApiSkill(getHiscore(CONSTRUCTION));

        this.bountyHunter = new ApiMiniGame(getHiscore(BOUNTY_HUNTER));
        this.bountyHunterRogues = new ApiMiniGame(getHiscore(BOUNTY_HUNTER_ROGUES));
        this.lastManStanding = new ApiMiniGame(getHiscore(LAST_MAN_STANDING));

        this.clueScrolls = new ApiClueScroll(getHiscore(CLUE_SCROLLS));
        this.easyClueScrolls = new ApiClueScroll(getHiscore(EASY_CLUE_SCROLLS));
        this.mediumClueScrolls = new ApiClueScroll(getHiscore(MEDIUM_CLUE_SCROLLS));
        this.hardClueScrolls = new ApiClueScroll(getHiscore(HARD_CLUE_SCROLLS));
        this.eliteClueScrolls = new ApiClueScroll(getHiscore(ELITE_CLUE_SCROLLS));
        this.masterClueScrolls = new ApiClueScroll(getHiscore(MASTER_CLUE_SCROLLS));
    }

    /**
     * Get the hiscore value based off the orginal of the enum
     *
     * @param osrsHiScore the enum for the array lookup
     * @return the hiscore for the given hiscore enum ordinal
     */
    public String getHiscore(OsrsHiScore osrsHiScore) {
        return hiscores[osrsHiScore.ordinal()];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ApiPlayerResponse playerResponse = (ApiPlayerResponse) obj;
        log.error("getOverall: {}", playerResponse.getOverall() == this.overall);
        return playerResponse.getOverall().equals(this.overall) &&
                playerResponse.getAttack().equals(this.attack) &&
                playerResponse.getDefence().equals(this.defence) &&
                playerResponse.getStrength().equals(this.strength) &&
                playerResponse.getHitpoints().equals(this.hitpoints) &&
                playerResponse.getRanged().equals(this.ranged) &&
                playerResponse.getPrayer().equals(this.prayer) &&
                playerResponse.getMagic().equals(this.magic) &&
                playerResponse.getCooking().equals(this.cooking) &&
                playerResponse.getWoodcutting().equals(this.woodcutting) &&
                playerResponse.getFletching().equals(this.fletching) &&
                playerResponse.getFishing().equals(this.fishing) &&
                playerResponse.getFiremaking().equals(this.firemaking) &&
                playerResponse.getCrafting().equals(this.crafting) &&
                playerResponse.getSmithing().equals(this.smithing) &&
                playerResponse.getMining().equals(this.mining) &&
                playerResponse.getHerblore().equals(this.herblore) &&
                playerResponse.getAgility().equals(this.agility) &&
                playerResponse.getThieving().equals(this.thieving) &&
                playerResponse.getSlayer().equals(this.slayer) &&
                playerResponse.getFarming().equals(this.farming) &&
                playerResponse.getRunecrafting().equals(this.runecrafting) &&
                playerResponse.getHunter().equals(this.hunter) &&
                playerResponse.getConstruction().equals(this.construction) &&

                playerResponse.getBountyHunter().equals(this.bountyHunter) &&
                playerResponse.getBountyHunterRogues().equals(this.bountyHunterRogues) &&
                playerResponse.getLastManStanding().equals(this.lastManStanding) &&

                playerResponse.getClueScrolls().equals(this.clueScrolls) &&
                playerResponse.getEasyClueScrolls().equals(this.easyClueScrolls) &&
                playerResponse.getMediumClueScrolls().equals(this.mediumClueScrolls) &&
                playerResponse.getHardClueScrolls().equals(this.hardClueScrolls) &&
                playerResponse.getEliteClueScrolls().equals(this.eliteClueScrolls) &&
                playerResponse.getMasterClueScrolls().equals(this.masterClueScrolls);
    }

    @Override
    public int hashCode() {
        final int prime = 29;
        int hashCode = 1;
        hashCode = prime * hashCode + this.overall.hashCode();
        hashCode = prime * hashCode + this.attack.hashCode();
        hashCode = prime * hashCode + this.defence.hashCode();
        hashCode = prime * hashCode + this.strength.hashCode();
        hashCode = prime * hashCode + this.hitpoints.hashCode();
        hashCode = prime * hashCode + this.ranged.hashCode();
        hashCode = prime * hashCode + this.prayer.hashCode();
        hashCode = prime * hashCode + this.magic.hashCode();
        hashCode = prime * hashCode + this.cooking.hashCode();
        hashCode = prime * hashCode + this.woodcutting.hashCode();
        hashCode = prime * hashCode + this.fletching.hashCode();
        hashCode = prime * hashCode + this.fishing.hashCode();
        hashCode = prime * hashCode + this.firemaking.hashCode();
        hashCode = prime * hashCode + this.crafting.hashCode();
        hashCode = prime * hashCode + this.smithing.hashCode();
        hashCode = prime * hashCode + this.mining.hashCode();
        hashCode = prime * hashCode + this.herblore.hashCode();
        hashCode = prime * hashCode + this.agility.hashCode();
        hashCode = prime * hashCode + this.thieving.hashCode();
        hashCode = prime * hashCode + this.slayer.hashCode();
        hashCode = prime * hashCode + this.farming.hashCode();
        hashCode = prime * hashCode + this.runecrafting.hashCode();
        hashCode = prime * hashCode + this.hunter.hashCode();
        hashCode = prime * hashCode + this.construction.hashCode();

        hashCode = prime * hashCode + this.bountyHunter.hashCode();
        hashCode = prime * hashCode + this.bountyHunterRogues.hashCode();
        hashCode = prime * hashCode + this.lastManStanding.hashCode();

        hashCode = prime * hashCode + this.clueScrolls.hashCode();
        hashCode = prime * hashCode + this.easyClueScrolls.hashCode();
        hashCode = prime * hashCode + this.mediumClueScrolls.hashCode();
        hashCode = prime * hashCode + this.hardClueScrolls.hashCode();
        hashCode = prime * hashCode + this.eliteClueScrolls.hashCode();
        hashCode = prime * hashCode + this.masterClueScrolls.hashCode();
        return hashCode;
    }
}
