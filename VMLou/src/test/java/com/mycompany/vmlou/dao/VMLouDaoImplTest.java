/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vmlou.dao;

import com.mycompany.vmlou.dao.VMLouDao;
import com.mycompany.vmlou.dao.VMLouDaoImpl;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import com.mycompany.vmlou.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JCLog
 */
public class VMLouDaoImplTest {

    private VMLouDao dao;

    public VMLouDaoImplTest() {
        dao = new VMLouDaoImpl();
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
