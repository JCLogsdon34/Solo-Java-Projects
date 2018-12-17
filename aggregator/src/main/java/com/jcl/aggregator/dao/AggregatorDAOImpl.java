package com.jcl.aggregator.dao;

import com.jcl.aggregator.dto.Contact;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JCLog
 */
public class AggregatorDAOImpl implements AggregatorDAO {
    
    private Map<String, Contact> contacts = new HashMap<>();
    
    @Override
    public List<Contact> getAllContacts()
            throws AggregatorPersistenceException {
        loadTable();
        return new ArrayList<Contact>(contacts.values());
    }
    
    @Override
    public Contact getContact(String name)
            throws AggregatorPersistenceException, AggregatorNoSuchListingException {
        loadTable();
        return contacts.get(name);
    }
    
    @Override
    public void assembleTable(List<Contact> contactList) 
            throws AggregatorPersistenceException{
        for(Contact c : contactList){            
        contacts.put(c.getName(), c);
        }
        writeTable();
    }
    
    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        String nameSearchCriteria
                = criteria.get(SearchTerm.NAME);
        String titleSearchCriteria
                = criteria.get(SearchTerm.TITLE);
        String phoneNumberSearchCriteria
                = criteria.get(SearchTerm.PHONE_NUMBER);
        String webAddressSearchCriteria
                = criteria.get(SearchTerm.WEB_ADDRESS);

        Predicate<Contact> nameMatchPredicate;
        Predicate<Contact> titleMatchPredicate;
        Predicate<Contact> phoneNumberMatchPredicate;
        Predicate<Contact> webAddressMatchPredicate;

        Predicate<Contact> truePredicate = (c) -> {
            return true;
        };

        if (nameSearchCriteria == null
                || nameSearchCriteria.isEmpty()) {
            nameMatchPredicate = truePredicate;
        } else {
            nameMatchPredicate
                    = (c) -> c.getName().equals(nameSearchCriteria);
        }

        if (titleSearchCriteria == null
                || titleSearchCriteria.isEmpty()) {
            titleMatchPredicate = truePredicate;
        } else {
            titleMatchPredicate
                    = (d) -> d.getTitle().equals(titleSearchCriteria);
        }

        if (phoneNumberSearchCriteria == null
                || phoneNumberSearchCriteria.isEmpty()) {
            phoneNumberMatchPredicate = truePredicate;
        } else {
            phoneNumberMatchPredicate
                    = (d) -> d.getPhoneNumber().equals(phoneNumberSearchCriteria);
        }

        if (webAddressSearchCriteria == null
                || webAddressSearchCriteria.isEmpty()) {
            webAddressMatchPredicate = truePredicate;
        } else {
            webAddressMatchPredicate
                    = (d) -> d.getWebAddress().equals(webAddressSearchCriteria);
        }

        return contacts.values().stream()
                .filter(nameMatchPredicate
                        .and(titleMatchPredicate)
                        .and(phoneNumberMatchPredicate)
                        .and(webAddressMatchPredicate))
                .collect(Collectors.toList());
    }

    public static final String TABLE_FILE = "table.txt";
    public static final String DELIMITER = "||";

      private void loadTable() throws AggregatorPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TABLE_FILE)));
        } catch (FileNotFoundException e) {
            throw new AggregatorPersistenceException(
                    "-_- Could not load table data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Contact currentContact = new Contact(currentTokens[0]);
            currentContact.setTitle(currentTokens[1]);
            currentContact.setPhoneNumber(currentTokens[2]);
            currentContact.setWebAddress(currentTokens[3]);
            contacts.put(currentContact.getName(), currentContact);
        }
        scanner.close();
    }

    private void writeTable() throws AggregatorPersistenceException{

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(TABLE_FILE));
        } catch (IOException e) {
            throw new AggregatorPersistenceException(
                    "Could not save Table data.", e);
        }

        List<Contact> contactList = this.getAllContacts();
        for (Contact currentContact : contactList) {
            out.println(currentContact.getName() + DELIMITER
                    + currentContact.getTitle() + DELIMITER
                    + currentContact.getPhoneNumber() + DELIMITER
                    + currentContact.getWebAddress());
            out.flush();
        }
        out.close();
    }
}