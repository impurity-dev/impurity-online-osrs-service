package com.impurityonline.osrs.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemTrends {
    @JsonProperty("current")
    private String current;
    @JsonProperty("today")
    private String today;
    @JsonProperty("day_30")
    private String day30;
    @JsonProperty("day_90")
    private String day90;
    @JsonProperty("day_180")
    private String day180;
}
