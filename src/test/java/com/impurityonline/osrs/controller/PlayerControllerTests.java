package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.controller.response.player.PlayerResponse;
import com.impurityonline.osrs.domain.player.Player;
import com.impurityonline.osrs.exception.OsrsClientPlayerHttpRequestException;
import com.impurityonline.osrs.exception.PlayerNotFoundException;
import com.impurityonline.osrs.service.PlayerService;
import com.impurityonline.osrs.utils.configs.AbstractControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidOsrsPlayer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author impurity
 */
class PlayerControllerTests extends AbstractControllerTest {

    @MockBean
    private PlayerService playerService;
    private final String MOCK_PLAYER_NAME = "abc123";

    @Test
    @DisplayName("When getting a osrs player, return 200 and player")
    void osrs_player_return_200() throws Exception {
        Player player = getValidOsrsPlayer("apples", "bananas");
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setPlayer(player);

        when(playerService.getPlayer(MOCK_PLAYER_NAME)).thenReturn(player);
        mockMvc.perform(get("/v1/players/" + MOCK_PLAYER_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        mapToJson(playerResponse)
                ));
    }

    @Test
    @DisplayName("When getting a osrs player and is not found, return 404")
    void no_osrs_player_return_404() throws Exception {
        when(playerService.getPlayer(MOCK_PLAYER_NAME)).thenThrow(PlayerNotFoundException.class);
        mockMvc.perform(get("/v1/players/" + MOCK_PLAYER_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs player and it cannot be created, return 500")
    void osrs_player_return_500() throws Exception {
        when(playerService.getPlayer(MOCK_PLAYER_NAME)).thenThrow(OsrsClientPlayerHttpRequestException.class);
        mockMvc.perform(get("/v1/players/" + MOCK_PLAYER_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
