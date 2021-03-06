/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.servicelayer;

import com.jcl.aggregator.dao.AggregatorNoSuchListingException;
import com.jcl.aggregator.dao.AggregatorPersistenceException;
import com.jcl.aggregator.dao.SearchTerm;
import com.jcl.aggregator.dto.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JCLog
 */
public interface AggregatorServiceLayer {
    
    
    public List<Contact> getAllContacts()
            throws AggregatorPersistenceException;
    
    public Contact getContact(String name)
            throws AggregatorPersistenceException, AggregatorNoSuchListingException;
    
    public List<Contact> displayFromExcel();
    
    public void assembleTable(List<Contact> contactList) throws AggregatorPersistenceException;

    public List<Contact> searchContacts(Map<SearchTerm, String> criteria);
    
}