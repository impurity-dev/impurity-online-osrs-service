package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.enums.OsrsHiScore;
import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import static com.impurityonline.osrs.enums.OsrsHiScore.*;

/**
 * Raw string returned back from
 *
 * @author impurity
 */
@Slf4j
@Data
public class ApiPlayerResponse {
    private static final int HISCORE_TOTAL = 34;
    private String[] hiscores;
    private ApiSkillResponse overall;
    private ApiSkillResponse attack;
    private ApiSkillResponse defence;
    private ApiSkillResponse strength;
    private ApiSkillResponse hitpoints;
    private ApiSkillResponse ranged;
    private ApiSkillResponse prayer;
    private ApiSkillResponse magic;
    private ApiSkillResponse cooking;
    private ApiSkillResponse woodcutting;
    private ApiSkillResponse fletching;
    private ApiSkillResponse fishing;
    private ApiSkillResponse firemaking;
    private ApiSkillResponse crafting;
    private ApiSkillResponse smithing;
    private ApiSkillResponse mining;
    private ApiSkillResponse herblore;
    private ApiSkillResponse agility;
    private ApiSkillResponse thieving;
    private ApiSkillResponse slayer;
    private ApiSkillResponse farming;
    private ApiSkillResponse runecrafting;
    private ApiSkillResponse hunter;
    private ApiSkillResponse construction;
    private ApiMiniGameResponse bountyHunter;
    private ApiMiniGameResponse bountyHunterRogues;
    private ApiMiniGameResponse lastManStanding;
    private ApiClueScrollResponse clueScrolls;
    private ApiClueScrollResponse easyClueScrolls;
    private ApiClueScrollResponse mediumClueScrolls;
    private ApiClueScrollResponse hardClueScrolls;
    private ApiClueScrollResponse eliteClueScrolls;
    private ApiClueScrollResponse masterClueScrolls;

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

        this.overall = new ApiSkillResponse(getHiscore(OVERALL));
        this.attack = new ApiSkillResponse(getHiscore(ATTACK));
        this.defence = new ApiSkillResponse(getHiscore(DEFENCE));
        this.strength = new ApiSkillResponse(getHiscore(STRENGTH));
        this.hitpoints = new ApiSkillResponse(getHiscore(HITPOINTS));
        this.ranged = new ApiSkillResponse(getHiscore(RANGED));
        this.prayer = new ApiSkillResponse(getHiscore(PRAYER));
        this.magic = new ApiSkillResponse(getHiscore(MAGIC));
        this.cooking = new ApiSkillResponse(getHiscore(COOKING));
        this.woodcutting = new ApiSkillResponse(getHiscore(WOODCUTTING));
        this.fletching = new ApiSkillResponse(getHiscore(FLETCHING));
        this.fishing = new ApiSkillResponse(getHiscore(FISHING));
        this.firemaking = new ApiSkillResponse(getHiscore(FIREMAKING));
        this.crafting = new ApiSkillResponse(getHiscore(CRAFTING));
        this.smithing = new ApiSkillResponse(getHiscore(SMITHING));
        this.mining = new ApiSkillResponse(getHiscore(MINING));
        this.herblore = new ApiSkillResponse(getHiscore(HERBLORE));
        this.agility = new ApiSkillResponse(getHiscore(AGILITY));
        this.thieving = new ApiSkillResponse(getHiscore(THIEVING));
        this.slayer = new ApiSkillResponse(getHiscore(SLAYER));
        this.farming = new ApiSkillResponse(getHiscore(FARMING));
        this.runecrafting = new ApiSkillResponse(getHiscore(RUNECRAFTING));
        this.hunter = new ApiSkillResponse(getHiscore(HUNTER));
        this.construction = new ApiSkillResponse(getHiscore(CONSTRUCTION));

        this.bountyHunter = new ApiMiniGameResponse(getHiscore(BOUNTY_HUNTER));
        this.bountyHunterRogues = new ApiMiniGameResponse(getHiscore(BOUNTY_HUNTER_ROGUES));
        this.lastManStanding = new ApiMiniGameResponse(getHiscore(LAST_MAN_STANDING));

        this.clueScrolls = new ApiClueScrollResponse(getHiscore(CLUE_SCROLLS));
        this.easyClueScrolls = new ApiClueScrollResponse(getHiscore(EASY_CLUE_SCROLLS));
        this.mediumClueScrolls = new ApiClueScrollResponse(getHiscore(MEDIUM_CLUE_SCROLLS));
        this.hardClueScrolls = new ApiClueScrollResponse(getHiscore(HARD_CLUE_SCROLLS));
        this.eliteClueScrolls = new ApiClueScrollResponse(getHiscore(ELITE_CLUE_SCROLLS));
        this.masterClueScrolls = new ApiClueScrollResponse(getHiscore(MASTER_CLUE_SCROLLS));
    }

    /**
     * Get the hiscore value based off the orginal of the enum
     *
     * @param osrsHiScore the enum for the array lookup
     * @return the hiscore for the given hiscore enum ordinal
     */
    private String getHiscore(OsrsHiScore osrsHiScore) {
        return hiscores[osrsHiScore.ordinal()];
    }
}
