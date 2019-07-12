package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.Player;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsPlayerResponse {
    @JsonProperty("player")
    private Player player;
}
