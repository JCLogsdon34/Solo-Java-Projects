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
    public Contact getContact(String term)
            throws AggregatorPersistenceException, AggregatorNoSuchListingException {
        loadTable();
        //// implement for loops here
        return contacts.get(term);
    }
    
    @Override
    public void assembleTable(List<Contact> contactList) 
            throws AggregatorPersistenceException{
        for(Contact c : contactList){            
        contacts.put(c.getName(), c);
        }
        writeTable();
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
            currentContact.setName(currentTokens[1]);
            currentContact.setTitle(currentTokens[2]);
            currentContact.setPhoneNumber(currentTokens[3]);
            currentContact.setWebAddress(currentTokens[4]);
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