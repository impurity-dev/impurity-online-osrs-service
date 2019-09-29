package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Osrs raw string converted into a clue scroll reponse
 *
 * @author impurity
 */
@Slf4j
@Data
public class ApiClueScrollResponse {
    private static final int SCROLL_HISCORE_TOTAL = 2;
    private Long rank;
    private Long score;

    /**
     * Create api clue response based off hiscore values
     *
     * @param scrollHiscores the api returned clue scroll hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiClueScrollResponse(@NonNull String scrollHiscores) throws ApiPlayerResponseException {
        String[] scores = scrollHiscores.split(",");
        if (scores.length != SCROLL_HISCORE_TOTAL) {
            log.error("Not valid scroll hiscores count: hiscores={}", scrollHiscores);
            throw new ApiPlayerResponseException("Invalid scroll hiscores length");
        }
        try {
            this.rank = Long.parseLong(scores[0]);
            this.score = Long.parseLong(scores[1]);
        } catch(NumberFormatException ex) {
            log.error("Not valid scroll hiscores values: hiscores={}", scrollHiscores);
            throw new ApiPlayerResponseException("Invalid scroll hiscores values");
        }
    }
}
