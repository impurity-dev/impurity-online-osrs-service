package com.impurityonline.osrs.client;

import com.impurityonline.osrs.exception.RestTemplateClientException;
import com.impurityonline.osrs.exception.RestTemplateServerException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author impurity
 */
@Slf4j
public abstract class RestClient {
    @Getter
    private final RestTemplate restTemplate;

    /**
     * Create the rest template client
     */
    public RestClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Create the header with the required header fields
     *
     * @return the header with the required fields added
     */
    protected abstract HttpHeaders getHeaders();

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
    protected <T> ResponseEntity<T> executeRequest(HttpMethod method, String uri, HttpEntity entity, Class<T> clazz)
            throws RestTemplateClientException {
        try {
            log.info("Request: Method={} Uri={}", method.toString(), uri);
            return restTemplate.exchange(uri, method, entity, clazz);
        } catch(HttpClientErrorException ex) {
            log.error("Could not complete request: Message: {} - Body: {}", ex.getMessage(), ex.getResponseBodyAsString());
            throw new RestTemplateClientException("Get Request Failure", ex.getStatusCode(), ex);
        } catch(HttpServerErrorException ex) {
            log.error("Could not complete request: Message: {} - Body: {}", ex.getMessage(), ex.getResponseBodyAsString());
            throw new RestTemplateServerException("Get Request Failure", ex.getStatusCode(), ex);
        }
    }
}
