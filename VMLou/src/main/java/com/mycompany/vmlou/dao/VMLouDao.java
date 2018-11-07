package com.mycompany.vmlou.dao;

import com.mycompany.vmlou.dto.Item;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface VMLouDao {

    Item createOrder(String itemCode, Item item)
            throws VMLouPersistenceException,
            VMLouNotInStockException;

    List<Item> getAllItems()
            throws VMLouPersistenceException;

    Item getItem(String itemCode);

    void editItem(String itemCode, Item item)
            throws VMLouPersistenceException;

    Item removeItem(String itemCode)
            throws VMLouPersistenceException;
    
    void loadInventory()throws VMLouPersistenceException;
    
    void writeInventory()throws VMLouPersistenceException;

}
