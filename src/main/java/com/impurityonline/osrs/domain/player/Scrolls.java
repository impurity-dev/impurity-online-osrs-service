package com.impurityonline.osrs.domain.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Scrolls {
    @JsonProperty("clue_scrolls")
    private Scroll clueScrolls;
    @JsonProperty("easy_clue_scrolls")
    private Scroll easyClueScrolls;
    @JsonProperty("medium_clue_scrolls")
    private Scroll mediumClueScrolls;
    @JsonProperty("hard_clue_scrolls")
    private Scroll hardClueScrolls;
    @JsonProperty("elite_clue_scrolls")
    private Scroll eliteClueScrolls;
    @JsonProperty("master_clue_scrolls")
    private Scroll masterClueScrolls;
}
