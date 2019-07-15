package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemTrends;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemTrendsResponse {
    @JsonProperty("trends")
    private ItemTrends trends;
}
