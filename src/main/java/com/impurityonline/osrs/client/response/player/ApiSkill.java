package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Getter;
import lombok.NonNull;

/**
 * Raw string returned back from
 *
 * @author impurity
 */
@Getter
public class ApiSkill {
    private static final int SKILL_HISCORE_TOTAL = 3;
    private final Long rank;
    private final Long level;
    private final Long experience;

    /**
     * Create api skill response based off hiscore values
     *
     * @param skillHiscores the api returned skill hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiSkill(@NonNull String skillHiscores) throws ApiPlayerResponseException {
        String[] scores = skillHiscores.split(",");
        if (scores.length != SKILL_HISCORE_TOTAL) {
            throw new ApiPlayerResponseException("Invalid skill hiscores length");
        }
        this.rank = Long.parseLong(scores[0]);
        this.level = Long.parseLong(scores[1]);
        this.experience = Long.parseLong(scores[2]);
    }
}
