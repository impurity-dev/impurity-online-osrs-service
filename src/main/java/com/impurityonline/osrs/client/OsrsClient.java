package com.impurityonline.osrs.client;

import com.impurityonline.osrs.client.response.OsrsApiItemResponse;
import com.impurityonline.osrs.exception.OsrsClientItemHttpRequestException;
import com.impurityonline.osrs.exception.OsrsClientPlayerHttpRequestException;
import com.impurityonline.osrs.exception.RestTemplateClientException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.impurityonline.osrs.builder.OsrsUrlBuilder.buildGrandExchangeURL;
import static com.impurityonline.osrs.builder.OsrsUrlBuilder.buildPlayerURL;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_HTML;

/**
 * @author impurity
 */
@Slf4j
@Component
public class OsrsClient extends RestClient {

    /**
     * Create an Osrs client
     * The client has supported mediatypes: application/json, text/plain, text/html
     * This is required since the
     */
    public OsrsClient() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(APPLICATION_JSON, TEXT_HTML));
        getRestTemplate().setMessageConverters(Arrays.asList(mappingJackson2HttpMessageConverter));
    }

    @Override
    protected HttpHeaders getHeaders() {
        return new HttpHeaders();
    }

    /**
     * Get a OSRS player based off he player name
     *
     * @param playerName - Player name
     * @return - Player hiscores
     */
    public ResponseEntity<String> getPlayer(@NonNull final String playerName) {
        try {
            return executeRequest(
                    HttpMethod.GET,
                    buildPlayerURL(playerName).toUriString(),
                    new HttpEntity<>(this.getHeaders()),
                    String.class
            );
        } catch (RestTemplateClientException ex) {
            log.error("Osrs Client Issues: {}", ex.getMessage());
            throw new OsrsClientPlayerHttpRequestException("Cannot get player", ex.getStatus(), ex);
        }
    }

    /**
     * Get a OSRS item based off he item id
     *
     * @param itemId - Item id
     * @return - Player item
     */
    public ResponseEntity<OsrsApiItemResponse> getItem(@NonNull final Long itemId) {
        try {
            return executeRequest(
                    HttpMethod.GET,
                    buildGrandExchangeURL(itemId).toUriString(),
                    new HttpEntity<>(this.getHeaders()),
                    OsrsApiItemResponse.class
            );
        } catch (RestTemplateClientException ex) {
            log.error("Osrs Client Issues: {}", ex.getMessage());
            throw new OsrsClientItemHttpRequestException("Cannot get item", ex.getStatus(), ex);
        }
    }
}
