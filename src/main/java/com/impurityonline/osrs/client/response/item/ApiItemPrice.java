package com.impurityonline.osrs.client.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ApiItemPrice {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("price")
    private String price;
}