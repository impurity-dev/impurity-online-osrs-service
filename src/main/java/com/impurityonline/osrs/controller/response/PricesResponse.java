package com.impurityonline.osrs.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.item.ItemPrice;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class PricesResponse {
    @JsonProperty("current")
    private ItemPrice current;
    @JsonProperty("today")
    private ItemPrice today;
}