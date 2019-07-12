package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsScrolls {
    @JsonProperty("clueScrolls")
    private OsrsScroll clueScrolls;
    @JsonProperty("easyClueScrolls")
    private OsrsScroll easyClueScrolls;
    @JsonProperty("mediumClueScrolls")
    private OsrsScroll mediumClueScrolls;
    @JsonProperty("hardClueScrolls")
    private OsrsScroll hardClueScrolls;
    @JsonProperty("eliteClueScrolls")
    private OsrsScroll eliteClueScrolls;
    @JsonProperty("masterClueScrolls")
    private OsrsScroll masterClueScrolls;
}