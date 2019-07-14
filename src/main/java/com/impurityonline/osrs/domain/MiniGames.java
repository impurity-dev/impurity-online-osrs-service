package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class MiniGames {
    @JsonProperty("bounty_hunter")
    @JsonAlias("bountyHunter")
    private MiniGame bountyHunter;
    @JsonProperty("bounty_hunter_rogues")
    @JsonAlias("bountyHunterRogues")
    private MiniGame bountyHunterRogues;
    @JsonProperty("last_man_standing")
    @JsonAlias("lastManStanding")
    private MiniGame lastManStanding;
}
