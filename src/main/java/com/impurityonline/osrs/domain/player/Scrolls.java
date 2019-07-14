package com.impurityonline.osrs.domain.player;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Scrolls {
    @JsonProperty("clue_scrolls")
    @JsonAlias("clueScrolls")
    private Scroll clueScrolls;
    @JsonProperty("easy_clue_scrolls")
    @JsonAlias("easyClueScrolls")
    private Scroll easyClueScrolls;
    @JsonProperty("medium_clue_scrolls")
    @JsonAlias("mediumClueScrolls")
    private Scroll mediumClueScrolls;
    @JsonProperty("hard_clue_scrolls")
    @JsonAlias("hardClueScrolls")
    private Scroll hardClueScrolls;
    @JsonProperty("elite_clue_scrolls")
    @JsonAlias("eliteClueScrolls")
    private Scroll eliteClueScrolls;
    @JsonProperty("master_clue_scrolls")
    @JsonAlias("masterClueScrolls")
    private Scroll masterClueScrolls;
}
