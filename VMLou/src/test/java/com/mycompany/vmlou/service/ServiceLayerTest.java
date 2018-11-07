package com.mycompany.vmlou.service;

import com.mycompany.vmlou.dto.Item;
import com.mycompany.vmlou.dto.Change;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JCLog
 */
public class ServiceLayerTest {

    private ServiceLayer service;

    public ServiceLayerTest() {
       
          ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("test-applicationContext.xml");
    service = 
        ctx.getBean("service", ServiceLayerImpl.class);
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
    public void testGetItem() throws Exception {
        assertNotNull(service.getItem("1936"));
    }

    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(1, service.getAllItems().size());
    }

    @Test
    public void testGetItemInvalidData()
            throws Exception {
        String itemCode = "1871";
        try {
            service.getItem(itemCode);
            fail("Expected VMLouDataValidationException was not thrown.");
        } catch (VMLouDataValidationException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderValidData()
            throws Exception {
        String itemCode = "1936";
        Item currentItem = service.getItem(itemCode);
        assertNotNull(currentItem);
        assertEquals(currentItem.getItemCode(), itemCode);
    }

    @Test
    public void testMoneyCheck()
            throws Exception {
        String itemCode = "1936";
        Item currentItem = service.getItem(itemCode);
        assertNotNull(currentItem);
        BigDecimal payment = new BigDecimal("1.50");
        assertEquals(currentItem.getItemPrice(), payment);
    }

    @Test
    public void testGetItemInsufficientFunds()
            throws Exception {
        String itemCode = "1936";
        BigDecimal payment = new BigDecimal("1.40");
        Item currentItem = service.getItem(itemCode);
        try {
            service.enoughMoney(payment, currentItem.getItemPrice());
            fail("Expected VMLouInsufficientFundsException was not thrown.");
        } catch (VMLouInsufficientFundsException e) {
            return;
        }
    }

    @Test
    public void testRemoveItem()
            throws Exception {
        String itemCode = "1936";
        Item currentItem = service.removeItem(itemCode);
        assertEquals(itemCode, currentItem.getItemCode());
    }

    @Test
    public void testMoneyRefund()
            throws Exception {
        String itemCode = "1936";
        int changeBack = 7;
        Item currentItem = service.getItem(itemCode);
        Change change = new Change();
        assertNotNull(currentItem);
        BigDecimal payment = new BigDecimal("1.75").setScale(2);

        change = service.returnChange(payment);
        assertEquals(changeBack, change.getNumofQuarter());
        assertNotEquals(currentItem.getItemPrice(), payment);
    }
}
