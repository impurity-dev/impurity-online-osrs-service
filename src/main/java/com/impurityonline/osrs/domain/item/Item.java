package com.impurityonline.osrs.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Item {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("members")
    private Boolean members;
    @JsonProperty("icons")
    private ItemIcons icons;
    @JsonProperty("prices")
    private ItemPrices prices;
    @JsonProperty("changes")
    private ItemChanges changes;
    @JsonProperty("trends")
    private ItemTrends trends;
}
