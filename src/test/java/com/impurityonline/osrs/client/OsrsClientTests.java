package com.impurityonline.osrs.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.impurityonline.osrs.client.response.OsrsApiItemResponse;
import com.impurityonline.osrs.exception.OsrsClientItemHttpRequestException;
import com.impurityonline.osrs.exception.OsrsClientPlayerHttpRequestException;
import com.impurityonline.osrs.exception.RestTemplateServerException;
import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

import static com.impurityonline.osrs.builder.UrlBuilder.buildGrandExchangeURL;
import static com.impurityonline.osrs.builder.UrlBuilder.buildPlayerURL;
import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidOsrsApiItemResponse;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidOsrsPlayerClientResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 * @author tmk2003
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OsrsClientTests extends AbstractTest {

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
    void osrsClient_with_OK_osrsApiPlayerResponse() {
        String playerName = "123";
        String osrsApiPlayerResponse = getValidOsrsPlayerClientResponse();
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(osrsApiPlayerResponse)
                );
        assertEquals(osrsApiPlayerResponse, osrsClient.getPlayer(playerName).getBody());
    }

    @Test
    @DisplayName("When the steam client library has client error, throw OsrsClientPlayerHttpRequestException")
    void osrsClient_with_CLIENTERROR_osrsApiPlayerResponse() {
        String playerName = "123";
        String osrsApiPlayerResponse = getValidOsrsPlayerClientResponse();
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(osrsApiPlayerResponse)
                );
        assertThrows(OsrsClientPlayerHttpRequestException.class, () -> osrsClient.getPlayer(playerName));
    }

    @Test
    @DisplayName("When the steam client library has server error, throw RestTemplateServerException")
    void osrsClient_with_SERVERERROR_osrsApiPlayerResponse() {
        String playerName = "123";
        String osrsApiPlayerResponse = getValidOsrsPlayerClientResponse();
        mockServer.expect(once(), requestTo(buildPlayerURL(playerName).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(osrsApiPlayerResponse)
                );
        assertThrows(RestTemplateServerException.class, () -> osrsClient.getPlayer(playerName));
    }
    @Test
    @DisplayName("When the osrs client item has null itemid, throw null pointer")
    void osrsClient_item_null_itemId() {
        assertThrows(NullPointerException.class, () -> osrsClient.getItem(null));
    }

    @Test
    @DisplayName("When the osrs client gets itemid, return response")
    void osrsClient_with_OK_osrsApiItemResponse() throws JsonProcessingException {
        Long itemId = 123L;
        OsrsApiItemResponse osrsApiPlayerResponse = getValidOsrsApiItemResponse();
        mockServer.expect(once(), requestTo(buildGrandExchangeURL(itemId).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToJson(osrsApiPlayerResponse))
                );
        assertEquals(osrsApiPlayerResponse, osrsClient.getItem(itemId).getBody());
    }

    @Test
    @DisplayName("When the osrs client item has client error, throw OsrsClientItemHttpRequestException")
    void osrsClient_with_CLIENTERROR_osrsApiItemResponse() throws JsonProcessingException {
        Long itemId = 123L;
        OsrsApiItemResponse osrsApiPlayerResponse = getValidOsrsApiItemResponse();
        mockServer.expect(once(), requestTo(buildGrandExchangeURL(itemId).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToJson(osrsApiPlayerResponse))
                );
        assertThrows(OsrsClientItemHttpRequestException.class, () -> osrsClient.getItem(itemId));
    }

    @Test
    @DisplayName("When the steam client library has server error, throw RestTemplateServerException")
    void osrsClient_with_SERVERERROR_osrsApiItemResponse() throws JsonProcessingException {
        Long itemId = 123L;
        OsrsApiItemResponse osrsApiPlayerResponse = getValidOsrsApiItemResponse();
        mockServer.expect(once(), requestTo(buildGrandExchangeURL(itemId).toUriString()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToJson(osrsApiPlayerResponse))
                );
        assertThrows(RestTemplateServerException.class, () -> osrsClient.getItem(itemId));
    }
}
