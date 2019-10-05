package com.impurityonline.osrs.client.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * JSON item price returned back from the OSRS api
 *
 * @author impurity
 */
@Data
public class ApiItemPrice {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("price")
    private String price;
}