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
            throw new ApiPlayerResponseException("Invalid scroll hiscores length");
        }
        this.rank = Long.parseLong(scores[0]);
        this.score = Long.parseLong(scores[1]);
    }
}
