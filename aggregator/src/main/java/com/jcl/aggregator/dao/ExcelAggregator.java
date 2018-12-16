/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.dao;

import com.jcl.dto.Contact;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface ExcelAggregator {
    
    public List<Contact> displayFromExcel();
    
}
