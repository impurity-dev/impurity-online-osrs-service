package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Raw string returned back from
 *
 * @author impurity
 */
@Slf4j
@Data
public class ApiSkillResponse {
    private static final int SKILL_HISCORE_TOTAL = 3;
    private Long rank;
    private Long level;
    private Long experience;

    /**
     * Create api skill response based off hiscore values
     *
     * @param skillHiscores the api returned skill hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiSkillResponse(@NonNull String skillHiscores) throws ApiPlayerResponseException {
        String[] scores = skillHiscores.split(",");
        if (scores.length != SKILL_HISCORE_TOTAL) {
            log.error("Not valid skill hiscores count: hiscores={}", skillHiscores);
            throw new ApiPlayerResponseException("Invalid skill hiscores length");
        }
        try {
            this.rank = Long.parseLong(scores[0]);
            this.level = Long.parseLong(scores[1]);
            this.experience = Long.parseLong(scores[2]);
        } catch(NumberFormatException ex) {
            log.error("Not valid skill hiscores values: hiscores={}", skillHiscores);
            throw new ApiPlayerResponseException("Invalid skill hiscores values");
        }
    }
}
