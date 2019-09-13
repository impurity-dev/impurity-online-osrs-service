package com.impurityonline.osrs.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.impurityonline.osrs.client.response.item.ApiItemResponse;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.exception.*;
import com.impurityonline.osrs.test.utils.configs.AbstractServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static com.impurityonline.osrs.factory.UrlFactory.buildGrandExchangeURL;
import static com.impurityonline.osrs.factory.UrlFactory.buildPlayerURL;
import static com.impurityonline.osrs.test.utils.OsrsFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 * @author tmk2003
 */
class OsrsClientTests extends AbstractServiceTest {

    @Autowired
    private OsrsClient osrsClient;
    private MockRestServiceServer mockServer;

    @BeforeEach
    void setup() {
        mockServer = MockRestServiceServer.createServer(osrsClient.getRestTemplate());
    }

    @Test
    @DisplayName("When the osrs client player has null playerName, throw null pointer")
    void osrsClient_player_null_playerName() {
        assertThrows(NullPointerException.class, () -> osrsClient.getPlayer(null));
    }

    @Test
    @DisplayName("When the osrs client gets player, return response")
    void osrsClient_with_OK_osrsApiPlayerResponse() throws ApiPlayerResponseException, ClientRestException, ServerRestException {
        String playerName = "123";
        String apiPlayerResponseString = getValidApiPlayerResponseString();
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(apiPlayerResponseString)
                );
        assertEquals(new ApiPlayerResponse(apiPlayerResponseString), osrsClient.getPlayer(playerName));
    }

    @Test
    @DisplayName("When the osrs client player has response error, throw ClientRestException")
    void osrsClient_with_RESPONSEERROR_ServerRestException() {
        String playerName = "123";
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(getInvalidApiPlayerResponseString())
                );
        assertThrows(ClientRestException.class, () -> osrsClient.getPlayer(playerName));
    }

    @Test
    @DisplayName("When the osrs client player has client error, throw ClientRestException")
    void osrsClient_with_CLIENTERROR_osrsApiPlayerResponse() {
        String playerName = "123";
        String osrsApiPlayerResponse = getValidApiPlayerResponseString();
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(osrsApiPlayerResponse)
                );
        assertThrows(ClientRestException.class, () -> osrsClient.getPlayer(playerName));
    }

    @Test
    @DisplayName("When the osrs client player has client error, throw ClientRestException")
    void osrsClient_with_CLIENTERROR_invalidResponse() {
        String playerName = "123";
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("")
                );
        assertThrows(ClientRestException.class, () -> osrsClient.getPlayer(playerName));
    }

    @Test
    @DisplayName("When the osrs client player has server error, throw ServerRestException")
    void osrsClient_with_SERVERERROR_osrsApiPlayerResponse() {
        String playerName = "123";
        String osrsApiPlayerResponse = getValidApiPlayerResponseString();
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(osrsApiPlayerResponse)
                );
        assertThrows(ServerRestException.class, () -> osrsClient.getPlayer(playerName));
    }

    @Test
    @DisplayName("When the osrs client item has null itemid, throw null pointer")
    void osrsClient_item_null_itemId() {
        assertThrows(NullPointerException.class, () -> osrsClient.getItem(null));
    }

    @Test
    @DisplayName("When the osrs client gets itemid, return response")
    void osrsClient_with_OK_osrsApiItemResponse() throws JsonProcessingException, ClientRestException, ServerRestException {
        Long itemId = 123L;
        ApiItemResponse osrsApiPlayerResponse = getValidApiItemResponse();
        mockServer.expect(once(), requestTo(buildGrandExchangeURL(itemId).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToJson(osrsApiPlayerResponse))
                );
        assertEquals(osrsApiPlayerResponse, osrsClient.getItem(itemId));
    }

    @Test
    @DisplayName("When the osrs client item has client error, throw ClientRestException")
    void osrsClient_with_CLIENTERROR_osrsApiItemResponse() throws JsonProcessingException {
        Long itemId = 123L;
        ApiItemResponse osrsApiPlayerResponse = getValidApiItemResponse();
        mockServer.expect(once(), requestTo(buildGrandExchangeURL(itemId).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToJson(osrsApiPlayerResponse))
                );
        assertThrows(ClientRestException.class, () -> osrsClient.getItem(itemId));
    }

    @Test
    @DisplayName("When the osrs client item has server error, throw ServerRestException")
    void osrsClient_with_SERVERERROR_osrsApiItemResponse() throws JsonProcessingException {
        Long itemId = 123L;
        ApiItemResponse osrsApiPlayerResponse = getValidApiItemResponse();
        mockServer.expect(once(), requestTo(buildGrandExchangeURL(itemId).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToJson(osrsApiPlayerResponse))
                );
        assertThrows(ServerRestException.class, () -> osrsClient.getItem(itemId));
    }
}
