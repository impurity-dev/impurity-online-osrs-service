package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemPricesResponse {
    @JsonProperty("current")
    private String current;
    @JsonProperty("today")
    private String today;
}
