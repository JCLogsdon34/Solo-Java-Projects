package com.mycompany.vmlou.service;
/**
 *
 * @author JCLog
 */
public class VMLouDataValidationException extends Exception {
    
     public VMLouDataValidationException(String message) {
        super(message);
    }

    public VMLouDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
