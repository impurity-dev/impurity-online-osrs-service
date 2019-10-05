package com.impurityonline.osrs.controller.response.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.player.Player;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class PlayerResponse {
    @JsonProperty("player")
    private Player player;
}
