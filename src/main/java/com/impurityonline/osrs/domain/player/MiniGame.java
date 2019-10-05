package com.impurityonline.osrs.domain.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class MiniGame {
    @JsonProperty("rank")
    private Long rank;
    @JsonProperty("score")
    private Long score;
}
