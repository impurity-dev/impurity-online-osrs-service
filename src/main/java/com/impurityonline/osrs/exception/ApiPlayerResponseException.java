package com.impurityonline.osrs.exception;

/**
 * @author impurity
 */
public class ApiPlayerResponseException extends Exception {
    private static final long serialVersionUID = -4902493208782862408L;

    /**
     * Generic Api Player response exception
     * @param message Explanatory Message
     */
    public ApiPlayerResponseException(String message) {
        super(message);
    }
}
