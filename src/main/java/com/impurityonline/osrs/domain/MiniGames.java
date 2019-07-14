package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class MiniGames {
    @JsonProperty("bountyHunter")
    private MiniGame bountyHunter;
    @JsonProperty("bountyHunterRogues")
    private MiniGame bountyHunterRogues;
    @JsonProperty("lastManStanding")
    private MiniGame lastManStanding;
}
