package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Item {
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
    private ItemPrice current;
    @JsonProperty("today")
    private ItemPrice today;
    @JsonProperty("day30")
    private ItemTrend day30;
    @JsonProperty("day90")
    private ItemTrend day90;
    @JsonProperty("day180")
    private ItemTrend day180;
}
