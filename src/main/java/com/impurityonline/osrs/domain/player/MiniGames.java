package com.impurityonline.osrs.domain.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class MiniGames {
    @JsonProperty("bounty_hunter")
    private MiniGame bountyHunter;
    @JsonProperty("bounty_hunter_rogues")
    private MiniGame bountyHunterRogues;
    @JsonProperty("last_man_standing")
    private MiniGame lastManStanding;
}
