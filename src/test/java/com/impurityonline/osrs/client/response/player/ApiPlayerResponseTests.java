package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponseString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
class ApiPlayerResponseTests extends AbstractTest {
    String getInvalidApiPlayerResponseString() {
        return "a,1328,39039916\n" +
                "195711,91,6103476\n" +
                "205897,89,5298921\n" +
                "379871,90,5360274\n" +
                "289325,93,7515747\n" +
                "384239,87,4244478\n" +
                "501686,64,425495\n" +
                "449344,83,2679530\n" +
                "930420,58,236075\n" +
                "1339240,51,117752\n" +
                "1288040,30,13705\n" +
                "745048,62,335272\n" +
                "687565,59,264653\n" +
                "666942,59,258067\n" +
                "582299,56,187666\n" +
                "162560,76,1356244\n" +
                "401936,58,237626\n" +
                "667564,58,224811\n" +
                "1231633,28,11508\n" +
                "168429,87,4147823\n" +
                "1706522,1,0\n" +
                "1017801,15,2642\n" +
                "1288615,1,10\n" +
                "763340,32,18141\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "93027,500\n" +
                "-1,-1\n" +
                "234068,1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1";
    }
    String getLongInvalidApiPlayerResponseString() {
        return getValidApiPlayerResponseString() + "\n-1,-1";
    }

    private static String validApiPlayerResponseString;

    @BeforeAll
    public static void setup() {
        validApiPlayerResponseString = getValidApiPlayerResponseString();
    }

    @Test
    @DisplayName("When the api player response has null hiscores, throw null pointer")
    void apiPlayerResponse_nullHiScores_nullPointer() {
        assertThrows(NullPointerException.class, () -> new ApiPlayerResponse(null));
    }

    @Test
    @DisplayName("When the api player responsel has empty hiscores, throw apiPlayerResponseException")
    void apiPlayerResponse_emptyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiPlayerResponse(""));
    }

    @Test
    @DisplayName("When the api player response has too few hiscores, throw apiPlayerResponseException")
    void apiPlayerResponse_tooFewHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiPlayerResponse("1,"));
    }

    @Test
    @DisplayName("When the api player response has too many hiscores, throw apiPlayerResponseException")
    void apiPlayerResponse_tooManyHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiPlayerResponse(getLongInvalidApiPlayerResponseString()));
    }

    @Test
    @DisplayName("When the api player response has too many hiscores, throw apiPlayerResponseException")
    void apiPlayerResponse_invalidHiScores_apiPlayerResponseException() {
        assertThrows(ApiPlayerResponseException.class, () -> new ApiPlayerResponse(getInvalidApiPlayerResponseString()));
    }

    @Test
    @DisplayName("When the api skills hashcode, return proper hashcode")
    void apiSkills_hashCode() throws Exception {
        ApiPlayerResponse playerResponse = new ApiPlayerResponse(validApiPlayerResponseString);
        final int prime = 29;
        int hashCode = 1;
        hashCode = prime * hashCode + Arrays.hashCode(playerResponse.getHiscores());
        hashCode = prime * hashCode + playerResponse.getOverall().hashCode();
        hashCode = prime * hashCode + playerResponse.getAttack().hashCode();
        hashCode = prime * hashCode + playerResponse.getDefence().hashCode();
        hashCode = prime * hashCode + playerResponse.getStrength().hashCode();
        hashCode = prime * hashCode + playerResponse.getHitpoints().hashCode();
        hashCode = prime * hashCode + playerResponse.getRanged().hashCode();
        hashCode = prime * hashCode + playerResponse.getPrayer().hashCode();
        hashCode = prime * hashCode + playerResponse.getMagic().hashCode();
        hashCode = prime * hashCode + playerResponse.getCooking().hashCode();
        hashCode = prime * hashCode + playerResponse.getWoodcutting().hashCode();
        hashCode = prime * hashCode + playerResponse.getFletching().hashCode();
        hashCode = prime * hashCode + playerResponse.getFishing().hashCode();
        hashCode = prime * hashCode + playerResponse.getFiremaking().hashCode();
        hashCode = prime * hashCode + playerResponse.getCrafting().hashCode();
        hashCode = prime * hashCode + playerResponse.getSmithing().hashCode();
        hashCode = prime * hashCode + playerResponse.getMining().hashCode();
        hashCode = prime * hashCode + playerResponse.getHerblore().hashCode();
        hashCode = prime * hashCode + playerResponse.getAgility().hashCode();
        hashCode = prime * hashCode + playerResponse.getThieving().hashCode();
        hashCode = prime * hashCode + playerResponse.getSlayer().hashCode();
        hashCode = prime * hashCode + playerResponse.getFarming().hashCode();
        hashCode = prime * hashCode + playerResponse.getRunecrafting().hashCode();
        hashCode = prime * hashCode + playerResponse.getHunter().hashCode();
        hashCode = prime * hashCode + playerResponse.getConstruction().hashCode();

        hashCode = prime * hashCode + playerResponse.getBountyHunter().hashCode();
        hashCode = prime * hashCode + playerResponse.getBountyHunterRogues().hashCode();
        hashCode = prime * hashCode + playerResponse.getLastManStanding().hashCode();

        hashCode = prime * hashCode + playerResponse.getClueScrolls().hashCode();
        hashCode = prime * hashCode + playerResponse.getEasyClueScrolls().hashCode();
        hashCode = prime * hashCode + playerResponse.getMediumClueScrolls().hashCode();
        hashCode = prime * hashCode + playerResponse.getHardClueScrolls().hashCode();
        hashCode = prime * hashCode + playerResponse.getEliteClueScrolls().hashCode();
        hashCode = prime * hashCode + playerResponse.getMasterClueScrolls().hashCode();
        assertEquals(hashCode, playerResponse.hashCode());
    }
}
