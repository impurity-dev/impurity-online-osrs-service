package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsMiniGames {
    @JsonProperty("bountyHunter")
    private OsrsMiniGame bountyHunter;
    @JsonProperty("bountyHunterRogues")
    private OsrsMiniGame bountyHunterRogues;
    @JsonProperty("lastManStanding")
    private OsrsMiniGame lastManStanding;
}
