package com.impurityonline.osrs.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemIcons {
    @JsonProperty("type_icon")
    private String typeIcon;
    @JsonProperty("small_icon")
    private String smallIcon;
    @JsonProperty("large_icon")
    private String largeIcon;
}
