package com.impurityonline.osrs.domain.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Player {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("skills")
    private Skills skills;
    @JsonProperty("scrolls")
    private Scrolls scrolls;
    @JsonProperty("mini_games")
    private MiniGames miniGames;
}
