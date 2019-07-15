package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiClueScroll;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.Scroll;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
class ScrollBuilderTests extends AbstractTest {

    private static ApiPlayerResponse apiPlayerResponse;

    @BeforeAll
    public static void setup() throws Exception {
        apiPlayerResponse = getValidApiPlayerResponse();
    }

    @Test
    @DisplayName("When player api response is null, throw null pointer")
    void minigameBuilder_nullResponse_throwsNullpointer() {
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(null));
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsEasyClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getEasyClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getEasyClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsMediumClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getMediumClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getMediumClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the hard clue scroll")
    void scollBuild_buildsHardClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getHardClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getHardClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the elite clue scroll")
    void scollBuild_buildsEliteClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getEliteClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getEliteClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the master clue scroll")
    void scollBuild_buildsMasterClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getMasterClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getMasterClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }
}
