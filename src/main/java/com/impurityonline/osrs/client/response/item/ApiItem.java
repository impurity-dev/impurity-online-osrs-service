package com.impurityonline.osrs.client.response.item;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * JSON item returned back from the OSRS api
 *
 * @author impurity
 */
@Data
public class ApiItem {
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
    @JsonAlias("icon_large")
    private String iconLarge;
    @JsonProperty("members")
    private Boolean members;
    @JsonProperty("current")
    private ApiItemPrice current;
    @JsonProperty("today")
    private ApiItemPrice today;
    @JsonProperty("day30")
    private ApiItemTrend day30;
    @JsonProperty("day90")
    private ApiItemTrend day90;
    @JsonProperty("day180")
    private ApiItemTrend day180;
}