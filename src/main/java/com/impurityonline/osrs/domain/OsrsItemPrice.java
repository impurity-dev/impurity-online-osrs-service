package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsItemPrice {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("price")
    private Long price;
}
