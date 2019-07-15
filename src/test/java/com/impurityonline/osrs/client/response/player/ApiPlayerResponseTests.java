package com.impurityonline.osrs.client.response.player;

import com.impurityonline.osrs.exception.ApiPlayerResponseException;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.impurityonline.osrs.utils.OsrsFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author impurity
 */
class ApiPlayerResponseTests extends AbstractTest {

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
}
