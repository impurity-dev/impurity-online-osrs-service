package com.impurityonline.osrs.client;

import com.impurityonline.osrs.client.response.OsrsApiItemResponse;
import com.impurityonline.osrs.exception.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

import static com.impurityonline.osrs.builder.UrlBuilder.buildGrandExchangeURL;
import static com.impurityonline.osrs.builder.UrlBuilder.buildPlayerURL;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_HTML;

/**
 * @author impurity
 */
@Slf4j
@Component
public class OsrsClient extends RestClient {

    /**
     * Create client with supported media types: text/html application/json
     */
    public OsrsClient() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(TEXT_HTML, APPLICATION_JSON));
        getRestTemplate().getMessageConverters().add(converter);
    }

    /**
     * Get a OSRS player based off he player name
     *
     * @param playerName - Player name
     * @return - Player hiscores
     */
    public String getPlayer(@NonNull final String playerName) {
        try {
            ResponseEntity<String> playerEntity = executeRequest(
                    HttpMethod.GET,
                    buildPlayerURL(playerName).toUriString(),
                    new HttpEntity<>(new HttpHeaders()),
                    String.class
            );

            return Optional.ofNullable(playerEntity.getBody())
                    .orElseThrow(() -> new PlayerNotFoundException("No response body found for playerName=" + playerName));
        } catch (RestTemplateClientException ex) {
            log.error("Osrs Client Issues: {}", ex.getMessage());
            throw new OsrsClientPlayerHttpRequestException("Cannot get player", ex.getStatus(), ex);
        } catch (RestTemplateServerException ex) {
            log.error("Osrs Server Issues: {}", ex.getMessage());
            throw new OsrsClientPlayerHttpRequestException("Cannot get player", ex.getStatus(), ex);
        }
    }

    /**
     * Get a OSRS item based off he item id
     *
     * @param itemId - Item id
     * @return - Player item
     */
    public OsrsApiItemResponse getItem(@NonNull final Long itemId) {
        try {
            ResponseEntity<OsrsApiItemResponse> itemEntity = executeRequest(
                    HttpMethod.GET,
                    buildGrandExchangeURL(itemId).toUriString(),
                    new HttpEntity<>(new HttpHeaders()),
                    OsrsApiItemResponse.class
            );
            return Optional.ofNullable(itemEntity.getBody())
                    .orElseThrow(() -> new ItemNotFoundException("No response body found for itemId=" + itemId));
        } catch (RestTemplateClientException ex) {
            log.error("Osrs Client Issues: {}", ex.getMessage());
            throw new OsrsClientItemHttpRequestException("Cannot get item", ex.getStatus(), ex);
        } catch (RestTemplateServerException ex) {
            log.error("Osrs Server Issues: {}", ex.getMessage());
            throw new OsrsClientPlayerHttpRequestException("Cannot get item", ex.getStatus(), ex);
        }
    }
}
