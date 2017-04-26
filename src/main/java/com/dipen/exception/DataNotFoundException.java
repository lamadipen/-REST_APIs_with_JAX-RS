package com.dipen.exception;

/**
 * Created by dipen on 4/26/2017.
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
