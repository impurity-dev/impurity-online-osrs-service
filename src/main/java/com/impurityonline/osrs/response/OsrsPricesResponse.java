package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.OsrsItemPrice;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsPricesResponse {
    @JsonProperty("current")
    private OsrsItemPrice current;
    @JsonProperty("today")
    private OsrsItemPrice today;
}
