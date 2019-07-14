package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Scrolls {
    @JsonProperty("clueScrolls")
    private Scroll clueScrolls;
    @JsonProperty("easyClueScrolls")
    private Scroll easyClueScrolls;
    @JsonProperty("mediumClueScrolls")
    private Scroll mediumClueScrolls;
    @JsonProperty("hardClueScrolls")
    private Scroll hardClueScrolls;
    @JsonProperty("eliteClueScrolls")
    private Scroll eliteClueScrolls;
    @JsonProperty("masterClueScrolls")
    private Scroll masterClueScrolls;
}
