/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator;

import com.jcl.aggregator.dao.AggregatorNoSuchListingException;
import com.jcl.aggregator.dao.AggregatorPersistenceException;
import com.jcl.aggregator.dto.Contact;
import com.jcl.aggregator.servicelayer.AggregatorServiceLayer;
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

        }
        return "index";
    }

    @RequestMapping(value = "/displayContactsPage", method = RequestMethod.GET)
    public String displayAllContacts(Model model) {
        List<Contact> contactList = new ArrayList<>();
        try {
            contactList = service.getAllContacts();
        } catch (AggregatorPersistenceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        model.addAttribute("currentContact", contactList);
        return "contactsPage";
    }

    @RequestMapping(value = "/getContact", method = RequestMethod.GET)
    public String getContact(HttpServletRequest request, Model model) {
        List<Contact> contactList = new ArrayList<>();
        String term = request.getParameter("term");
        Contact contact = new Contact();
        try {
            contact = service.getContact(term);
        } catch (AggregatorNoSuchListingException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        } catch (AggregatorPersistenceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        contactList.add(contact);
        model.addAttribute("contactList", contactList);
        return "contactsDetails";
    }
}
