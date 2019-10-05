package com.impurityonline.osrs.client;

import com.impurityonline.osrs.exception.ClientRestException;
import com.impurityonline.osrs.exception.ServerRestException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author impurity
 */
@Slf4j
@Component
abstract class RestClient {
    @Getter
    private final RestTemplate restTemplate;

    /**
     * Create the rest template client
     */
    RestClient() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(new RestClientErrorHandler());
    }

    /**
     *  Perform the GET request to the provided URI
     *
     * @param method The restful method
     * @param uri The URI to perform the request to
     * @param entity The entity we are sending to the URI
     * @param clazz The expected object type to receive back
     * @param <T> The Class type of the returned object
     * @return The Response from the GET request
     */
    <T> ResponseEntity<T> executeRequest(HttpMethod method, String uri, HttpEntity entity, Class<T> clazz)
            throws ClientRestException, ServerRestException {
        try {
            log.info("Request: Method={} Uri={}", method.toString(), uri);
            return restTemplate.exchange(uri, method, entity, clazz);
        } catch(HttpClientErrorException ex) {
            log.error("Could not complete request: Message: {} - Body: {}", ex.getMessage(), ex.getResponseBodyAsString());
            throw new ClientRestException("Get Request Failure", ex.getStatusCode(), ex);
        } catch(HttpServerErrorException ex) {
            log.error("Could not complete request: Message: {} - Body: {}", ex.getMessage(), ex.getResponseBodyAsString());
            throw new ServerRestException("Get Request Failure", ex.getStatusCode(), ex);
        }
    }
}
