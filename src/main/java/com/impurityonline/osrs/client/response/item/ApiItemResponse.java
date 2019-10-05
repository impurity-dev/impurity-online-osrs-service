package com.impurityonline.osrs.client.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * JSON item response returned back from the OSRS api
 *
 * @author impurity
 */
@Data
public class ApiItemResponse {
    @JsonProperty("item")
    private ApiItem item;
}