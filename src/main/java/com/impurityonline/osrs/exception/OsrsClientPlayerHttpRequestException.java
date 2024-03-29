package com.impurityonline.osrs.exception;

import org.springframework.http.HttpStatus;

/**
 * @author impurity
 */
public class OsrsClientPlayerHttpRequestException extends HttpRequestException {
    private static final long serialVersionUID = -4955276495660819867L;

    /**
     * Generic Osrs Exception
     *
     * @param message Explanatory message
     * @param status Http status
     * @param cause The causing exception
     */
    public OsrsClientPlayerHttpRequestException(String message, HttpStatus status, Throwable cause) {
        super(message, status, cause);
    }
}
