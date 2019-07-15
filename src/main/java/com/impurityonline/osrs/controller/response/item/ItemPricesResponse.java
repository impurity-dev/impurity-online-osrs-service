package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemPrices;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemPricesResponse {
    @JsonProperty("prices")
    private ItemPrices prices;
}
