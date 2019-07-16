package com.impurityonline.osrs.factory;

import com.impurityonline.osrs.client.response.player.ApiClueScrollResponse;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.Scroll;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponse;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidScroll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author impurity
 */
class ScrollFactoryTests extends AbstractTest {

    private static ApiPlayerResponse apiPlayerResponse;

    @BeforeAll
    public static void setup() throws Exception {
        apiPlayerResponse = getValidApiPlayerResponse();
    }

    @Test
    @DisplayName("When player api response is null, throw null pointer")
    void minigameFactory_nullResponse_throwsNullpointer() {
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(null));
    }

    @Test
    @DisplayName("When clue scroll is null, throw null pointer")
    void minigameFactory_nullClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(null);
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When easy clue scroll is null, throw null pointer")
    void minigameFactory_nullEasyClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(null);
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When medium clue scroll is null, throw null pointer")
    void minigameFactory_nullMediumClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(null);
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When hard clue scroll is null, throw null pointer")
    void minigameFactory_nullHardClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(null);
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When elite clue scroll is null, throw null pointer")
    void minigameFactory_nullEliteClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(null);
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When master clue scroll is null, throw null pointer")
    void minigameFactory_nullMasterClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> ScrollsFactory.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsClueScroll() {
        ApiClueScrollResponse expected = apiPlayerResponse.getClueScrolls();
        Scroll actual = ScrollsFactory.buildScrolls(apiPlayerResponse).getClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsEasyClueScroll() {
        ApiClueScrollResponse expected = apiPlayerResponse.getEasyClueScrolls();
        Scroll actual = ScrollsFactory.buildScrolls(apiPlayerResponse).getEasyClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsMediumClueScroll() {
        ApiClueScrollResponse expected = apiPlayerResponse.getMediumClueScrolls();
        Scroll actual = ScrollsFactory.buildScrolls(apiPlayerResponse).getMediumClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the hard clue scroll")
    void scollBuild_buildsHardClueScroll() {
        ApiClueScrollResponse expected = apiPlayerResponse.getHardClueScrolls();
        Scroll actual = ScrollsFactory.buildScrolls(apiPlayerResponse).getHardClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the elite clue scroll")
    void scollBuild_buildsEliteClueScroll() {
        ApiClueScrollResponse expected = apiPlayerResponse.getEliteClueScrolls();
        Scroll actual = ScrollsFactory.buildScrolls(apiPlayerResponse).getEliteClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the master clue scroll")
    void scollBuild_buildsMasterClueScroll() {
        ApiClueScrollResponse expected = apiPlayerResponse.getMasterClueScrolls();
        Scroll actual = ScrollsFactory.buildScrolls(apiPlayerResponse).getMasterClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }
}
