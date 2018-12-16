/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator;

import com.jcl.aggregator.dao.AggregatorDAO;
import com.jcl.dto.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JCLog
 */

public class SearchController {
 
    private AggregatorDAO dao;

    @Inject
    public SearchController(AggregatorDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/displaySearchPage", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }

//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    @ResponseBody
//    public List<Contact> searchContacts(@RequestBody Map<String, String> searchMap) {
//        // Create the map of search criteria to send to the DAO
//        
//        Map<SearchTerm, String> criteriaMap = new HashMap<>();
//
//        // Determine which search terms have values, translate the String
//        // keys into SearchTerm enums, and set the corresponding values
//        // appropriately.
//        String currentTerm = searchMap.get("name");
//        if (currentTerm != null && !currentTerm.isEmpty()) {
//            criteriaMap.put(SearchTerm.NAME, currentTerm);
//        }
//        currentTerm = searchMap.get("title");
//        if (currentTerm != null && !currentTerm.isEmpty()) {
//            criteriaMap.put(SearchTerm.TITLE, currentTerm);
//        }
//        currentTerm = searchMap.get("phoneNumber");
//        if (currentTerm != null && !currentTerm.isEmpty()) {
//            criteriaMap.put(SearchTerm.PHONE_NUMBER, currentTerm);
//        }
//        currentTerm = searchMap.get("webAddress");
//        if (currentTerm != null && !currentTerm.isEmpty()) {
//            criteriaMap.put(SearchTerm.WEB_ADDRESS, currentTerm);
//        }
//        return dao.searchContacts(criteriaMap);
//    }
    
}