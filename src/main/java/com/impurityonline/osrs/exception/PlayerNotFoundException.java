package com.impurityonline.osrs.exception;

/**
 * @author impurity
 */
public class PlayerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5675972332879532275L;

    /**
     * Generic Osrs Exception
     *
     * @param message Explanatory message
     */
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
