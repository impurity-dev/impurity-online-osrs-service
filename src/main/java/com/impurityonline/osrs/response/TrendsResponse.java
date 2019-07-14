package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.ItemTrend;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class TrendsResponse {
    @JsonProperty("day30")
    private ItemTrend day30;
    @JsonProperty("day90")
    private ItemTrend day90;
    @JsonProperty("day180")
    private ItemTrend day180;
}
