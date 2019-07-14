package com.impurityonline.osrs.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.Player;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class PlayerResponse {
    @JsonProperty("player")
    private Player player;
}
