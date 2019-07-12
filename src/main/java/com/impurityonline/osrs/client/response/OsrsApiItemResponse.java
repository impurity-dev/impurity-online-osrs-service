package com.impurityonline.osrs.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.Item;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsApiItemResponse {
    @JsonProperty("item")
    private Item item;
}