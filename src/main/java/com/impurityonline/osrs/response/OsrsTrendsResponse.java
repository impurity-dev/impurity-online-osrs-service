package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.OsrsItemPrice;
import com.impurityonline.osrs.domain.OsrsItemTrend;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsTrendsResponse {
    @JsonProperty("day30")
    private OsrsItemTrend day30;
    @JsonProperty("day90")
    private OsrsItemTrend day90;
    @JsonProperty("day180")
    private OsrsItemTrend day180;
}
