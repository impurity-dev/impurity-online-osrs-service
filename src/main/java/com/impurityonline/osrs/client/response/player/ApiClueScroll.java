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
public class ApiClueScroll {
    private static final int SCROLL_HISCORE_TOTAL = 2;
    private final Long rank;
    private final Long score;

    /**
     * Create api clue response based off hiscore values
     *
     * @param scrollHiscores the api returned clue scroll hiscores
     * @throws ApiPlayerResponseException if the hiscores are invalid
     */
    public ApiClueScroll(@NonNull String scrollHiscores) throws ApiPlayerResponseException {
        String[] scores = scrollHiscores.split(",");
        if (scores.length != SCROLL_HISCORE_TOTAL) {
            throw new ApiPlayerResponseException("Invalid scroll hiscores length");
        }
        this.rank = Long.parseLong(scores[0]);
        this.score = Long.parseLong(scores[1]);
    }
}
