package com.impurityonline.osrs.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class IconsResponse {
    @JsonProperty("type_icon")
    private String typeIcon;
    @JsonProperty("small_icon")
    private String smallIcon;
    @JsonProperty("large_icon")
    private String largeIcon;
}
