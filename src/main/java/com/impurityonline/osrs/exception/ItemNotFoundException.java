package com.impurityonline.osrs.exception;

/**
 * @author impurity
 */
public class ItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 3513739686319721275L;

    /**
     * Generic Osrs Exception
     *
     * @param message Explanatory message
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
