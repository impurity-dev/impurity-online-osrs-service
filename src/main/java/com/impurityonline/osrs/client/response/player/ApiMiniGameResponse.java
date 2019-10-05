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
public class ApiMiniGameResponse {
    private static final int MINIGAME_HISCORE_TOTAL = 2;
    private Long rank;
    private Long score;

    /**
     * Create api mini game response based off hiscore values
     *
     * @param minigameHiscores the api returned mini game hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiMiniGameResponse(@NonNull String minigameHiscores) throws ApiPlayerResponseException {
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
}
