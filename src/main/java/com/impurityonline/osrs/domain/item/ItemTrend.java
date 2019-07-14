package com.impurityonline.osrs.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemTrend {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("change")
    private String change;
}
