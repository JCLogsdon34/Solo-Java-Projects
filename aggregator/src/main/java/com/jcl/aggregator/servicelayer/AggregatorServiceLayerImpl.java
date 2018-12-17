/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.servicelayer;

import com.jcl.aggregator.dao.AggregatorDAO;
import com.jcl.aggregator.dao.AggregatorNoSuchListingException;
import com.jcl.aggregator.dao.AggregatorPersistenceException;
import com.jcl.aggregator.dto.Contact;
import java.util.List;
import javax.inject.Inject;
import com.jcl.aggregator.dao.ExcelAggregatorDAO;
import com.jcl.aggregator.dao.SearchTerm;
import java.util.Map;

/**
 *
 * @author JCLog
 */
public class AggregatorServiceLayerImpl implements AggregatorServiceLayer {
    
    private AggregatorDAO dao;
    private ExcelAggregatorDAO daoAgg;
        
    @Inject
    public AggregatorServiceLayerImpl(AggregatorDAO dao, ExcelAggregatorDAO daoAgg) {
        this.dao = dao;
        this.daoAgg = daoAgg;
    }
    
    @Override
    public List<Contact> getAllContacts() throws AggregatorPersistenceException {
        return dao.getAllContacts();
    }
    
    @Override
    public Contact getContact(String name)
            throws AggregatorPersistenceException, AggregatorNoSuchListingException {
        return dao.getContact(name);
    }
    
    @Override
    public List<Contact> displayFromExcel(){
        return daoAgg.displayFromExcel();
    }
    
    @Override
    public void assembleTable(List<Contact> contactList) 
            throws AggregatorPersistenceException {
        dao.assembleTable(contactList);
    } 
        
    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        return dao.searchContacts(criteria);
    }
    
}