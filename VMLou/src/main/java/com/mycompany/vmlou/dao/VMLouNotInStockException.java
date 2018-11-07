package com.mycompany.vmlou.dao;

/**
 *
 * @author JCLog
 */
public class VMLouNotInStockException extends Exception {

    public VMLouNotInStockException(String message) {
        super(message);
    }

    public VMLouNotInStockException(String message, Throwable cause) {
        super(message, cause);
    }

}
