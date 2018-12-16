/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.aggregator.dao;

import com.jcl.dto.Contact;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JCLog
 */
public class ExcelAggregatorImpl implements ExcelAggregator {

    public ExcelAggregatorImpl() {

    }

    @Override
    public List<Contact> displayFromExcel() {

    
        //test file is located in your project path         
        FileInputStream fileIn;
        String columnName = "CHFMN";
        String columnTitle = "CHFTITLE";
        String columnPhoneNumber = "GENTELE";
        String columnWebAddress = "WEBADDR";
        POIFSFileSystem fs;
        HSSFWorkbook filename;
        HSSFSheet sheet;
        List<Contact> contactList = new ArrayList<>();
        try {
            fileIn = new FileInputStream("postscndryunivsrvy2013dirinfo.csv");
            //read file 
            fs = new POIFSFileSystem(fileIn);
            filename = new HSSFWorkbook(fs);
            //open sheet 0 which is first sheet of your worksheet
            sheet = filename.getSheetAt(0);

            //we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
            Integer columnNoName = null;
            Integer columnNoTitle = null;
            Integer columnNoPhoneNumber = null;
            Integer columnNoWebAddress = null;
            //output all not null values to the list
            Cell c;
            Cell t;
            Cell p;
            Cell w;
            List<Cell> cells = new ArrayList<>();
            Contact contact = new Contact();
            Row firstRow = sheet.getRow(0);

            for (Cell cell : firstRow) {
                if (cell.getStringCellValue().equals(columnName)) {
                    columnNoName = cell.getColumnIndex();
                } else if (cell.getStringCellValue().equals(columnTitle)) {
                    columnNoTitle = cell.getColumnIndex();
                } else if (cell.getStringCellValue().equals(columnPhoneNumber)) {
                    columnNoPhoneNumber = cell.getColumnIndex();
                } else if (cell.getStringCellValue().equals(columnWebAddress)) {
                    columnNoWebAddress = cell.getColumnIndex();
                } else {
                    
                }             
            }
            
            if (columnNoName != null) {
                for (Row row : sheet) {
                    c = row.getCell(columnNoName);
                    if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
                        // Nothing in the cell in this row, skip it
                    } else {
                        contact.setName(c.getStringCellValue());
                        t = row.getCell(columnNoTitle);
                        contact.setTitle(t.getStringCellValue());
                        p = row.getCell(columnNoPhoneNumber);
                        contact.setPhoneNumber(p.getStringCellValue());
                        w = row.getCell(columnNoWebAddress);
                        contact.setWebAddress(w.getStringCellValue());
                        contactList.add(contact);
                       // cells.add(c);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ExcelAggregatorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactList;
    }

   
    
//    public void getMyCells() throws Exception {
//        //test file is located in your project path         
//        FileInputStream fileIn = new FileInputStream("postscndryunivsrvy2013dirinfo.csv");
//        //read file 
//        POIFSFileSystem fs = new POIFSFileSystem(fileIn);
//        HSSFWorkbook filename = new HSSFWorkbook(fs);
//        //open sheet 0 which is first sheet of your worksheet
//        HSSFSheet sheet = filename.getSheetAt(0);
//
//        //we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
//        String columnWanted = "CHFMN";
//        Integer columnNo = null;
//        //output all not null values to the list
//        List<Cell> cells = new ArrayList<Cell>();
//
//        Row firstRow = sheet.getRow(0);
//
//        for (Cell cell : firstRow) {
//            if (cell.getStringCellValue().equals(columnWanted)) {
//                columnNo = cell.getColumnIndex();
//            }
//        }
//        if (columnNo != null) {
//            for (Row row : sheet) {
//                Cell c = row.getCell(columnNo);
//                if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
//                    // Nothing in the cell in this row, skip it
//                } else {
//                    cells.add(c);
//                }
//            }
//        }
//    }
}
