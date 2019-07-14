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
    @JsonProperty("type_icon")
    @JsonAlias("typeIcon")
    private String typeIcon;
    @JsonProperty("small_icon")
    @JsonAlias("icon")
    private String smallIcon;
    @JsonProperty("large_icon")
    @JsonAlias("icon_large")
    private String largeIcon;
    @JsonProperty("members")
    private Boolean members;
    @JsonProperty("current")
    private ItemPrice current;
    @JsonProperty("today")
    private ItemPrice today;
    @JsonProperty("day_30")
    @JsonAlias("day30")
    private ItemTrend day30;
    @JsonProperty("day_90")
    @JsonAlias("day90")
    private ItemTrend day90;
    @JsonProperty("day_180")
    @JsonAlias("day180")
    private ItemTrend day180;
}
