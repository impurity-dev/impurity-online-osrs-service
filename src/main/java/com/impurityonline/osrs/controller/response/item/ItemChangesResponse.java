package com.impurityonline.osrs.controller.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ItemChangesResponse {
    @JsonProperty("day_30")
    private String day30;
    @JsonProperty("day_90")
    private String day90;
    @JsonProperty("day_180")
    private String day180;
}
