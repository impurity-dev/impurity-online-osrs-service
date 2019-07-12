package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.OsrsItemTrend;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsTrendResponse {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("change")
    private String change;
}
