package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.domain.OsrsPlayer;
import com.impurityonline.osrs.exception.OsrsClientPlayerHttpRequestException;
import com.impurityonline.osrs.exception.OsrsPlayerNotFoundException;
import com.impurityonline.osrs.response.OsrsPlayerResponse;
import com.impurityonline.osrs.service.PlayerService;
import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidOsrsPlayer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author impurity
 */
@Tag("Controller")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTests extends AbstractTest {

    @MockBean
    private PlayerService playerService;
    @Autowired
    private MockMvc mockMvc;
    private final String MOCK_PLAYER_NAME = "abc123";

    @Test
    @DisplayName("When getting a osrs player, return 200 and player")
    public void osrs_player_return_200() throws Exception {
        OsrsPlayer osrsPlayer = getValidOsrsPlayer("apples", "bananas");
        OsrsPlayerResponse osrsPlayerResponse = new OsrsPlayerResponse();
        osrsPlayerResponse.setPlayer(osrsPlayer);

        when(playerService.getPlayer(MOCK_PLAYER_NAME)).thenReturn(osrsPlayer);
        mockMvc.perform(get("/v1/players/" + MOCK_PLAYER_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        mapToJson(osrsPlayerResponse)
                ));
    }

    @Test
    @DisplayName("When getting a osrs player and is not found, return 404")
    public void no_osrs_player_return_404() throws Exception {
        when(playerService.getPlayer(MOCK_PLAYER_NAME)).thenThrow(OsrsPlayerNotFoundException.class);
        mockMvc.perform(get("/v1/players/" + MOCK_PLAYER_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs player and it cannot be created, return 500")
    public void osrs_player_return_500() throws Exception {
        when(playerService.getPlayer(MOCK_PLAYER_NAME)).thenThrow(OsrsClientPlayerHttpRequestException.class);
        mockMvc.perform(get("/v1/players/" + MOCK_PLAYER_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
