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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ApiClueScroll apiClueScroll = (ApiClueScroll) obj;
        return apiClueScroll.getRank().longValue() == this.getRank().longValue() &&
                apiClueScroll.getScore().longValue() == this.getScore().longValue();
    }
}
