package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.Item;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemResponse {
    @JsonProperty("item")
    private Item item;
}
