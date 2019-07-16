package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.test.utils.configs.AbstractServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.impurityonline.osrs.factory.MiniGameFactory.buildMiniGames;
import static com.impurityonline.osrs.factory.ScrollsFactory.buildScrolls;
import static com.impurityonline.osrs.factory.SkillsFactory.buildSkills;
import static com.impurityonline.osrs.test.utils.OsrsFactory.getValidApiPlayerResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * @author impurity
 */
class PlayerServiceImplTests extends AbstractServiceTest {
    @Mock
    private OsrsClient osrsClient;
    @InjectMocks
    private PlayerServiceImpl playerService;
    private static String MOCK_PLAYER_NAME = "1234";

    @Test
    @DisplayName("When playerName is nul, throw nullpointer")
    void getPlayer_nullName_throwNullPointer() {
        assertThrows(NullPointerException.class, () -> playerService.getPlayer(null));
    }

    @Test
    @DisplayName("When playerName is empty, throw illegal argument")
    void getPlayer_emptyName_throwIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> playerService.getPlayer(""));
    }

    @Test
    @DisplayName("When the client returns a valid player response, return the player with proper name")
    void getPlayer_validResponse_setProperName() throws Exception {
        when(osrsClient.getPlayer(MOCK_PLAYER_NAME)).thenReturn(getValidApiPlayerResponse());
        assertEquals(playerService.getPlayer(MOCK_PLAYER_NAME).getName(), MOCK_PLAYER_NAME);
    }

    @Test
    @DisplayName("When the client returns a valid player response, return the player with proper type")
    void getPlayer_validResponse_setProperType() throws Exception {
        when(osrsClient.getPlayer(MOCK_PLAYER_NAME)).thenReturn(getValidApiPlayerResponse());
        assertEquals(playerService.getPlayer(MOCK_PLAYER_NAME).getType(), "TODO");
    }

    @Test
    @DisplayName("When the client returns a valid player response, return the player with proper minigames")
    void getPlayer_validResponse_setProperMiniGames() throws Exception {
        when(osrsClient.getPlayer(MOCK_PLAYER_NAME)).thenReturn(getValidApiPlayerResponse());
        assertEquals(playerService.getPlayer(MOCK_PLAYER_NAME).getMiniGames(), buildMiniGames(getValidApiPlayerResponse()));
    }

    @Test
    @DisplayName("When the client returns a valid player response, return the player with proper scrolls")
    void getPlayer_validResponse_setProperScrolls() throws Exception {
        when(osrsClient.getPlayer(MOCK_PLAYER_NAME)).thenReturn(getValidApiPlayerResponse());
        assertEquals(playerService.getPlayer(MOCK_PLAYER_NAME).getScrolls(), buildScrolls(getValidApiPlayerResponse()));
    }

    @Test
    @DisplayName("When the client returns a valid player response, return the player with proper skills")
    void getPlayer_validResponse_setProperSkills() throws Exception {
        when(osrsClient.getPlayer(MOCK_PLAYER_NAME)).thenReturn(getValidApiPlayerResponse());
        assertEquals(playerService.getPlayer(MOCK_PLAYER_NAME).getSkills(), buildSkills(getValidApiPlayerResponse()));
    }
}
