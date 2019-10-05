package com.impurityonline.osrs.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemPrices {
    @JsonProperty("current")
    private String current;
    @JsonProperty("today")
    private String today;
}
