package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemTrend;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemTrendResponse {
    @JsonProperty("trend")
    private ItemTrend trend;
}
