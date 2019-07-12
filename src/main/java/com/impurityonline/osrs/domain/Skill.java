package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Skill {
    @JsonProperty("rank")
    private Long rank;
    @JsonProperty("level")
    private Long level;
    @JsonProperty("experience")
    private Long experience;
}
