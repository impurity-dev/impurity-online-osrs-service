package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.OsrsItem;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsItemResponse {
    @JsonProperty("item")
    private OsrsItem item;
}
