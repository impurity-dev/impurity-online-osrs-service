package com.impurityonline.osrs.exception;

/**
 * @author impurity
 */
public class OsrsPlayerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5675972332879532275L;

    /**
     * Generic Osrs Exception
     *
     * @param message Explanatory message
     */
    public OsrsPlayerNotFoundException(String message) {
        super(message);
    }
}
