package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.enums.OsrsHiScore;
import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

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
}
