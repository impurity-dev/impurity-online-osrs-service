package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.ItemPrice;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsPricesResponse {
    @JsonProperty("current")
    private ItemPrice current;
    @JsonProperty("today")
    private ItemPrice today;
}
