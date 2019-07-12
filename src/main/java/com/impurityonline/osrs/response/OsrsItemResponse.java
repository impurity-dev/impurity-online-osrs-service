package com.impurityonline.osrs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.osrs.domain.OsrsItemPrice;
import com.impurityonline.osrs.domain.OsrsItemTrend;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class OsrsItemResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("typeIcon")
    private String typeIcon;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("iconLarge")
    private String iconLarge;
    @JsonProperty("members")
    private Boolean members;
    @JsonProperty("current")
    private OsrsItemPrice current;
    @JsonProperty("today")
    private OsrsItemPrice today;
    @JsonProperty("day30")
    private OsrsItemTrend day30;
    @JsonProperty("day90")
    private OsrsItemTrend day90;
    @JsonProperty("day180")
    private OsrsItemTrend day180;
}
