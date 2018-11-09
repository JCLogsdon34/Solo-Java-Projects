/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vmlou.dao;

import com.mycompany.vmlou.dao.VMLouDao;
import com.mycompany.vmlou.dao.VMLouDaoJdbcTemplateImpl;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import com.mycompany.vmlou.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author JCLog
 */
public class VMLouDaoImplTest {

    private VMLouDao dao;

    private JdbcTemplate jdbcTemplate;

    public VMLouDaoImplTest() {
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        jdbcTemplate = factory.getBean(JdbcTemplate.class);
        dao = new VMLouDaoJdbcTemplateImpl(jdbcTemplate);

        // We have to empty the database for our tests.
        // Since we have a couple of nullable, foreign keys
        // it's easier to just set them to null and THEN delete
        // the other records. Otherwise, you would have to delete them in reverse order
        // of their entry.
        // Also, you could just use your dao delete methods, but that
        // will require that they work! This way, you bypass the dao
        // and manipulate the database directly.

        jdbcTemplate.execute("DELETE FROM Items WHERE 1=1");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws VMLouPersistenceException {
        dao.loadInventory();
    }

    @After
    public void tearDown() throws VMLouPersistenceException {
        String itemCode = "1903";
        Item currentItem = dao.getItem(itemCode);
        currentItem.setItemInventory(5);
        dao.editItem(itemCode, currentItem);
        dao.writeInventory();
    }
    
    @Test
    public Item addItem(Item item) {
        return dao.addItem(item);
    }

    @Test
    public void deleteItem(int itemID) {
        dao.deleteItem(itemID);
    }

    @Test
    public void updateItem(Item item) {
        dao.updateItem(item);
    }

    @Test
    public Item getItemByID(int itemID) {
        return dao.getItemByID(itemID);
    }

    @Test
    public List<Item> getAllItemsInDB() {
        return dao.getAllItemsInDB();
    }

    @Test
    public void testGetAllItems() throws VMLouPersistenceException {
        dao.loadInventory();
        assertEquals(10, dao.getAllItems().size());
    }

    @Test
    public void testGetItem() throws VMLouPersistenceException {
        String itemCode = "1832";
        String itemName = "Old Taylor";
        assertEquals(itemName, dao.getItem(itemCode).getItemName());
    }

    @Test
    public void testCreateOrderId() throws VMLouPersistenceException {
        String itemCode = "1999";
        assertEquals(dao.getItem(itemCode).getItemCode(), itemCode);
    }

    @Test
    public void testCreateOrderStock() throws VMLouPersistenceException {
        String itemCode = "1999";
        int itemInventory = 5;
        Item currentItem = dao.getItem(itemCode);
        assertEquals(itemInventory, currentItem.getItemInventory());
    }

    @Test
    public void testCreateOrderPay() throws VMLouPersistenceException {
        BigDecimal payment = new BigDecimal("2.75");
        String itemCode = "1953";
        Item currentItem = dao.getItem(itemCode);
        assertEquals(currentItem.getItemPrice(), payment);
    }

    @Test
    public void testCreateOrderCode() throws VMLouPersistenceException {
        String itemCode = "1952";
        Item currentItem = dao.getItem(itemCode);
        assertNull(currentItem);
    }

    @Test
    public void testGetItemNotInStock()
            throws Exception {
        String itemCode = "1903";
        Item currentItem = dao.getItem(itemCode);
        currentItem.setItemInventory(0);
        dao.editItem(itemCode, currentItem);
        try {
            dao.createOrder(itemCode, currentItem);
            fail("Expected VMLouNotInStockException was not thrown.");
        } catch (VMLouNotInStockException e) {
            return;
        }
    }

}
