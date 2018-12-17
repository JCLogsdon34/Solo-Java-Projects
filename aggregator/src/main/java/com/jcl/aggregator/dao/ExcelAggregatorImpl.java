/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.dao;

import static com.jcl.aggregator.dao.AggregatorDAOImpl.DELIMITER;
import static com.jcl.aggregator.dao.AggregatorDAOImpl.TABLE_FILE;
import com.jcl.aggregator.dto.Contact;
import java.io.BufferedReader;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JCLog
 */
public class ExcelAggregatorImpl implements ExcelAggregator {

    public ExcelAggregatorImpl() {

    }

    private Map<String, Contact> newContacts = new HashMap<>();
    
    @Override
    public List<Contact> displayFromExcel() {
        try {
            loadExcelDoc();
        } catch (AggregatorPersistenceException ex) {
            Logger.getLogger(ExcelAggregatorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }             
        return new ArrayList<Contact>(newContacts.values());
    }
        
        private void loadExcelDoc() throws AggregatorPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("postscndryunivsrvy2013dirinfo.csv")));
        } catch (FileNotFoundException e) {
            throw new AggregatorPersistenceException(
                    "-_- Could not load table data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Contact currentContact = new Contact(currentTokens[8]);
            currentContact.setName(currentTokens[9]);
            currentContact.setTitle(currentTokens[10]);
            currentContact.setPhoneNumber(currentTokens[11]);
            currentContact.setWebAddress(currentTokens[15]);
            newContacts.put(currentContact.getName(), currentContact);
        }
        scanner.close();
    }
}