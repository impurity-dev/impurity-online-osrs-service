package com.impurityonline.osrs.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemTrends {
    @JsonProperty("day_30")
    private ItemTrend day30;
    @JsonProperty("day_90")
    private ItemTrend day90;
    @JsonProperty("day_180")
    private ItemTrend day180;
}
