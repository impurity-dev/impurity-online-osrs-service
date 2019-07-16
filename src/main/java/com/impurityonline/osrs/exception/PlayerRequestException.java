package com.impurityonline.osrs.exception;

import org.springframework.http.HttpStatus;

/**
 * @author impurity
 */
public class PlayerRequestException extends HttpRequestException {
    private static final long serialVersionUID = 5869199903449373726L;

    /**
     * Generic Osrs Exception
     *
     * @param message Explanatory message
     * @param status Http status
     * @param cause The causing exception
     */
    public PlayerRequestException(String message, HttpStatus status, Throwable cause) {
        super(message, status, cause);
    }
}
