package com.impurityonline.osrs.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author impurity
 */
@Slf4j
public class RestClientErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus.Series series = response.getStatusCode().series();
        return series == HttpStatus.Series.CLIENT_ERROR || series == HttpStatus.Series.SERVER_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus.Series series = response.getStatusCode().series();
        switch (series) {
            case CLIENT_ERROR:
                log.error("Rest Client Error : Code={} : Message={}", response.getStatusText(), response.getStatusText());
                throw new HttpClientErrorException(response.getStatusCode(), response.getStatusText());
            case SERVER_ERROR:
                log.error("Rest Server Error : Code={} : Message={}", response.getStatusText(), response.getStatusText());
                throw new HttpServerErrorException(response.getStatusCode(), response.getStatusText());
            default:
                throw new IllegalStateException("RestClientErrorHandler shall not handle errors that are non client/server issues");
        }
    }
}
