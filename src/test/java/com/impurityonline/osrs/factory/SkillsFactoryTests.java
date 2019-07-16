package com.impurityonline.osrs.factory;

import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponse;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidSkill;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author impurity
 */
class SkillsFactoryTests extends AbstractTest {

    private static ApiPlayerResponse apiPlayerResponse;

    @BeforeAll
    public static void setup() throws Exception {
        apiPlayerResponse = getValidApiPlayerResponse();
    }

    @Test
    @DisplayName("When player api response is null, throw null pointer")
    void skillsFactory_nullResponse_throwsNullpointer() {
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(null));
    }

    @Test
    @DisplayName("When overall skill is null, throw null pointer")
    void skillsFactory_nullOverall_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(null);
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When attack skill is null, throw null pointer")
    void skillsFactory_nullAttack_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(null);
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When defence skill is null, throw null pointer")
    void skillsFactory_nullDefence_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(null);
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When strength skill is null, throw null pointer")
    void skillsFactory_nullStrength_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(null);
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When hitpoints skill is null, throw null pointer")
    void skillsFactory_nullHitpoints_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(null);
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When ranged skill is null, throw null pointer")
    void skillsFactory_nullRanged_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(null);
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When prayer skill is null, throw null pointer")
    void skillsFactory_nullPrayer_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(null);
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When magic skill is null, throw null pointer")
    void skillsFactory_nullMagic_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(null);
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When cooking skill is null, throw null pointer")
    void skillsFactory_nullCooking_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(null);
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When woodcutting skill is null, throw null pointer")
    void skillsFactory_nullWoodcutting_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(null);
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When fletching skill is null, throw null pointer")
    void skillsFactory_nullFletching_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(null);
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When fishing skill is null, throw null pointer")
    void skillsFactory_nullFishing_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(null);
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When firemaking skill is null, throw null pointer")
    void skillsFactory_nullFiremaking_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(null);
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When crafting skill is null, throw null pointer")
    void skillsFactory_nullCrafting_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(null);
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When smithing skill is null, throw null pointer")
    void skillsFactory_nullSmithing_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(null);
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When mining skill is null, throw null pointer")
    void skillsFactory_nullMining_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(null);
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When herblore skill is null, throw null pointer")
    void skillsFactory_nullHerblore_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(null);
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When agility skill is null, throw null pointer")
    void skillsFactory_nullAgility_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(null);
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When thieving skill is null, throw null pointer")
    void skillsFactory_nullThieving_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(null);
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When slayer skill is null, throw null pointer")
    void skillsFactory_nullSlayer_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(null);
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When farming skill is null, throw null pointer")
    void skillsFactory_nullFarming_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(null);
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When runecrafting skill is null, throw null pointer")
    void skillsFactory_nullRunecrafting_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(null);
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When hunter skill is null, throw null pointer")
    void skillsFactory_nullHunter_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(null);
        when(playerResponse.getConstruction()).thenReturn(getValidSkill());
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }

    @Test
    @DisplayName("When construction skill is null, throw null pointer")
    void skillsFactory_nullConstruction_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getOverall()).thenReturn(getValidSkill());
        when(playerResponse.getAttack()).thenReturn(getValidSkill());
        when(playerResponse.getDefence()).thenReturn(getValidSkill());
        when(playerResponse.getStrength()).thenReturn(getValidSkill());
        when(playerResponse.getHitpoints()).thenReturn(getValidSkill());
        when(playerResponse.getRanged()).thenReturn(getValidSkill());
        when(playerResponse.getPrayer()).thenReturn(getValidSkill());
        when(playerResponse.getMagic()).thenReturn(getValidSkill());
        when(playerResponse.getCooking()).thenReturn(getValidSkill());
        when(playerResponse.getWoodcutting()).thenReturn(getValidSkill());
        when(playerResponse.getFletching()).thenReturn(getValidSkill());
        when(playerResponse.getFishing()).thenReturn(getValidSkill());
        when(playerResponse.getFiremaking()).thenReturn(getValidSkill());
        when(playerResponse.getCrafting()).thenReturn(getValidSkill());
        when(playerResponse.getSmithing()).thenReturn(getValidSkill());
        when(playerResponse.getMining()).thenReturn(getValidSkill());
        when(playerResponse.getHerblore()).thenReturn(getValidSkill());
        when(playerResponse.getAgility()).thenReturn(getValidSkill());
        when(playerResponse.getThieving()).thenReturn(getValidSkill());
        when(playerResponse.getSlayer()).thenReturn(getValidSkill());
        when(playerResponse.getFarming()).thenReturn(getValidSkill());
        when(playerResponse.getRunecrafting()).thenReturn(getValidSkill());
        when(playerResponse.getHunter()).thenReturn(getValidSkill());
        when(playerResponse.getConstruction()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> SkillsFactory.buildSkills(playerResponse));
    }
}
