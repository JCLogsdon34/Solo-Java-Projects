package com.mycompany.vmlou.service;

/**
 *
 * @author JCLog
 */
public class VMLouInsufficientFundsException extends Exception {

    public VMLouInsufficientFundsException(String message) {
        super(message);
    }

    public VMLouInsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
