package com.mycompany.vmlou.service;

import com.mycompany.vmlou.dao.VMLouNotInStockException;
import com.mycompany.vmlou.dto.Change;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import com.mycompany.vmlou.dto.Item;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author JCLog
 */
public interface ServiceLayer {
    
    void createOrder(String itemCode, Item item)
            throws VMLouPersistenceException,
            VMLouDataValidationException,
            VMLouNotInStockException;
    
    BigDecimal enoughMoney(BigDecimal cash, BigDecimal itemPrice)
            throws VMLouInsufficientFundsException;

    Change returnChange(BigDecimal itemMoney);
    
    List<Item> getAllItems()
            throws VMLouPersistenceException;
    
    Item getItem(String itemChoice)
            throws VMLouDataValidationException,
            VMLouNotInStockException;

    void editItem(String itemCode, Item item)
            throws VMLouPersistenceException,
            VMLouDataValidationException;

    Item removeItem(String itemCode)
            throws VMLouPersistenceException;
    
    void loadInventory()
        throws VMLouPersistenceException;
    
    void writeInventory()
        throws VMLouPersistenceException;

    
}
