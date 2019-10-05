package com.impurityonline.osrs.domain.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class Skills {
    @JsonProperty("overall")
    private Skill overall;
    @JsonProperty("attack")
    private Skill attack;
    @JsonProperty("defence")
    private Skill defence;
    @JsonProperty("strength")
    private Skill strength;
    @JsonProperty("hitpoints")
    private Skill hitpoints;
    @JsonProperty("ranged")
    private Skill ranged;
    @JsonProperty("prayer")
    private Skill prayer;
    @JsonProperty("magic")
    private Skill magic;
    @JsonProperty("cooking")
    private Skill cooking;
    @JsonProperty("woodcutting")
    private Skill woodcutting;
    @JsonProperty("fletching")
    private Skill fletching;
    @JsonProperty("fishing")
    private Skill fishing;
    @JsonProperty("firemaking")
    private Skill firemaking;
    @JsonProperty("crafting")
    private Skill crafting;
    @JsonProperty("smithing")
    private Skill smithing;
    @JsonProperty("mining")
    private Skill mining;
    @JsonProperty("herblore")
    private Skill herblore;
    @JsonProperty("agility")
    private Skill agility;
    @JsonProperty("thieving")
    private Skill thieving;
    @JsonProperty("slayer")
    private Skill slayer;
    @JsonProperty("farming")
    private Skill farming;
    @JsonProperty("runecrafting")
    private Skill runecrafting;
    @JsonProperty("hunter")
    private Skill hunter;
    @JsonProperty("construction")
    private Skill construction;
}
