/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.dao;

/**
 *
 * @author JCLog
 */
public class AggregatorNoSuchListingException extends Exception{
    
      public AggregatorNoSuchListingException(String message) {
        super(message);
    }

    public AggregatorNoSuchListingException(String message, Throwable cause) {
        super(message, cause);
    }
}
