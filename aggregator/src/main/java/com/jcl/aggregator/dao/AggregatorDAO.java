package com.jcl.aggregator.dao;

import com.jcl.aggregator.dto.Contact;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JCLog
 */
public interface AggregatorDAO {
    
    public List<Contact> getAllContacts()
            throws AggregatorPersistenceException;
    
    public Contact getContact(String term)
            throws AggregatorPersistenceException, AggregatorNoSuchListingException;
    
    public void assembleTable(List<Contact> contactList) throws AggregatorPersistenceException;
    
}
