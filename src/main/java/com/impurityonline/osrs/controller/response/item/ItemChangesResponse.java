package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemChanges;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemChangesResponse {
    @JsonProperty("changes")
    private ItemChanges changes;
}
