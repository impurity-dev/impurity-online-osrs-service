package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsItemTrend {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("change")
    private String change;
}
