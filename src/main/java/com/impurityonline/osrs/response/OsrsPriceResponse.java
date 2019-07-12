package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.OsrsItem;
import com.impurityonline.osrs.domain.OsrsItemPrice;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsPriceResponse {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("price")
    private Long price;
}
