/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator;

import com.jcl.aggregator.dao.AggregatorNoSuchListingException;
import com.jcl.aggregator.dao.AggregatorPersistenceException;
import com.jcl.dto.Contact;
import com.jcl.servicelayer.AggregatorServiceLayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author JCLog
 */
public class Controller {
    
    private AggregatorServiceLayer service;

    @Inject
    public Controller(AggregatorServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLandingPage() {
        try {
        List<Contact> contactList = new ArrayList<>();
        contactList = service.displayFromExcel();
        service.assembleTable(contactList);
        } catch (AggregatorPersistenceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        return "index";
    }

    @RequestMapping(value = "/displayHomePage", method = RequestMethod.GET)
    public String displayHomePage(Model model) {        
        List<Contact> contactList = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();
        try{
        contactList = service.getAllContacts();

            int u = 0;
            int r = 0;
            u = contacts.size();
            r = u - 10;
            contacts.subList(0, r).clear();
            
        model.addAttribute("contacts", contacts);
        } catch (AggregatorPersistenceException e) {
          ///// nothing yet
          /// implement a message saying not able to load
        }
        return "homePage";
    }

   @RequestMapping(value = "/displayContactsPage", method = RequestMethod.GET)
    public String displayAllContacts(Model model) throws AggregatorPersistenceException {
        List<Contact> contacts = new ArrayList<>();
        contacts = service.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "contactsPage";
    }
    
    @RequestMapping(value = "/getContact", method = RequestMethod.GET)
    public String getContact(HttpServletRequest request, Model model) {
        List<Contact> contactList = new ArrayList<>();
        String term = request.getParameter("term");
        Contact contact = new Contact();
        try{
        contact = service.getContact(term);
        }catch(AggregatorNoSuchListingException e){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        } catch (AggregatorPersistenceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        contactList.add(contact);
        model.addAttribute("contactList", contactList);
        return "contactDetails";
    }
}
