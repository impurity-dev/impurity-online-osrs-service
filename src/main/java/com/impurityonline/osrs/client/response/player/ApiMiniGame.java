package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Raw string returned back from
 *
 * @author impurity
 */
@Slf4j
@Getter
public class ApiMiniGame {
    private static final int MINIGAME_HISCORE_TOTAL = 2;
    private final Long rank;
    private final Long score;

    /**
     * Create api mini game response based off hiscore values
     *
     * @param minigameHiscores the api returned mini game hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiMiniGame(@NonNull String minigameHiscores) throws ApiPlayerResponseException {
        String[] scores = minigameHiscores.split(",");
        if (scores.length != MINIGAME_HISCORE_TOTAL) {
            log.error("Not valid minigame hiscores count: hiscores={}", minigameHiscores);
            throw new ApiPlayerResponseException("Invalid minigame hiscores length");
        }
        try {
            this.rank = Long.parseLong(scores[0]);
            this.score = Long.parseLong(scores[1]);
        } catch(NumberFormatException ex) {
            log.error("Not valid minigame hiscores values: hiscores={}", minigameHiscores);
            throw new ApiPlayerResponseException("Invalid minigame hiscores values");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ApiMiniGame apiMiniGame = (ApiMiniGame) obj;
        return apiMiniGame.getRank().longValue() == this.rank.longValue() &&
                apiMiniGame.getScore().longValue() == this.score.longValue();
    }

    @Override
    public int hashCode() {
        final int prime = 19;
        int hashCode = 1;
        hashCode = prime * hashCode + rank.hashCode();
        hashCode = prime * hashCode + score.hashCode();
        return hashCode;
    }
}
