package com.impurityonline.osrs.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.ItemTrend;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class TrendsResponse {
    @JsonProperty("day_30")
    private ItemTrend day30;
    @JsonProperty("day_90")
    private ItemTrend day90;
    @JsonProperty("day_180")
    private ItemTrend day180;
}
