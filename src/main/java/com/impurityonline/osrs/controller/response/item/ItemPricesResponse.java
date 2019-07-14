package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemPrice;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemPricesResponse {
    @JsonProperty("current")
    private ItemPrice current;
    @JsonProperty("today")
    private ItemPrice today;
}
