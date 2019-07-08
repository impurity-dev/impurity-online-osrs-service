package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsPlayer {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("skills")
    private OsrsSkills skills;
    @JsonProperty("scrolls")
    private OsrsScrolls scrolls;
    @JsonProperty("miniGames")
    private OsrsMiniGames miniGames;
}
