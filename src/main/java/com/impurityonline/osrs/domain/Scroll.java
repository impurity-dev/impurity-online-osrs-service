package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Scroll {
    @JsonProperty("rank")
    private Long rank;
    @JsonProperty("score")
    private Long score;
}
