/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.daoimpltests;

import com.jcl.hermesreviews.dao.HermesReviewsDAO;
import com.jcl.hermesreviews.dao.HermesReviewsDAOImpl;
import com.jcl.hermesreviews.dto.Field;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author JCLog
 */
public class FieldTests {
    
    private HermesReviewsDAO testDao;
    private JdbcTemplate jdbcTemplate;
    
    public FieldTests() {
        
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        jdbcTemplate = factory.getBean(JdbcTemplate.class);
        testDao = new HermesReviewsDAOImpl(jdbcTemplate);
        
        jdbcTemplate.execute("DELETE FROM book_author WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM books WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM authors WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM fields WHERE 1=1");
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDaoConnectionDoesntExplode() {
        // Really stupid simple test.
        // It's just checking if it can connect to the dao at all, and if it explodes.
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        Assert.assertNotNull(jdbcTemplate);
        testDao = new HermesReviewsDAOImpl(jdbcTemplate);
    }
    
    @Test
    public void testAddField() {
         List<Field> p = new ArrayList<>();
        Field s = new Field();
        s.setFieldName("Anthropology");
        Field sP = new Field();
        
        sP.setFieldName("American Literature");
        p.add(s);
        p.add(sP);
        
        sP = testDao.createField(s);
        Assert.assertNotNull(sP); 
        Assert.assertEquals(sP.getFieldName(), "American Literature");
        Assert.assertEquals(s, sP);
    }
    
    @Test
    public void testDeleteField() {
        Field newField = new Field();
        Field returnedField = new Field();
        int id = 0;
        newField.setFieldName("Poetry");
        returnedField = testDao.createField(newField);
        testDao.deleteField(returnedField.getFieldID());
        id = returnedField.getFieldID();
        Assert.assertNull(testDao.getField(id));
    }
    

    @Test
    public void testUpdateField() {
        Field s = new Field();
        Field fromDb = new Field();
        s.setFieldName("Papyrology");

        testDao.createField(s);
        s.setFieldName("Papyrology");
        testDao.editField(s);
        fromDb = testDao.getField(s.getFieldID());
        assertEquals(fromDb, s);
    }

    @Test
    public void testGetFieldByID() {
        Field sP = new Field();
        Field s = new Field();
        Field sPP = new Field();
        sP.setFieldName("Egyptology");

        
        sPP = testDao.createField(sP);
        s = testDao.getField(sPP.getFieldID());
        Assert.assertNotNull(sPP);
        Assert.assertEquals(sPP.getFieldID(), s.getFieldID());
        Assert.assertEquals(sPP.getFieldName(), "Egyptology");
        Assert.assertEquals(sP, sPP);
    }

    @Test
    public void testDisplayAllFields() {
        Field s = new Field();
        Field sP = new Field();
        Field sPP = new Field();
        sP.setFieldName("Philology");

        s.setFieldName("Ancient History");

        sPP.setFieldName("Archeology");

        testDao.createField(sP);
        testDao.createField(s);
        testDao.createField(sPP);
        List<Field> hList = new ArrayList<>();
        List<Field> oList = new ArrayList<>();
        hList = testDao.getAllFields();
        oList = testDao.getAllFields();
        Assert.assertNotNull(hList);
        Assert.assertNotNull(oList);
        Assert.assertEquals(hList.size(), oList.size());   
    }
    
}