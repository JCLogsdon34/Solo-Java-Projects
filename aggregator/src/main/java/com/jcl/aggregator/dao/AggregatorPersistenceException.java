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
public class AggregatorPersistenceException extends Exception{
    
      public AggregatorPersistenceException(String message) {
        super(message);
    }

    public AggregatorPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
