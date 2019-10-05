package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemIcons;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemIconsResponse {
    @JsonProperty("icons")
    private ItemIcons icons;
}
