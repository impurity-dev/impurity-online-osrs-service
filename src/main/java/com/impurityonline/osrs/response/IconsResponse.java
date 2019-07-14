package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.ItemPrice;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class IconsResponse {
    @JsonProperty("typeIcon")
    private String typeIcon;
    @JsonProperty("smallIcon")
    private String smallIcon;
    @JsonProperty("largeIcon")
    private String largeIcon;
}
