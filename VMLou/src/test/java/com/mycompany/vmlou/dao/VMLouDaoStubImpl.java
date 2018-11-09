package com.mycompany.vmlou.dao;

import com.mycompany.vmlou.dao.VMLouDao;
import com.mycompany.vmlou.dao.VMLouNotInStockException;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import com.mycompany.vmlou.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class VMLouDaoStubImpl implements VMLouDao {

    private Item onlyItem;
    private List<Item> itemList = new ArrayList<>();

    public VMLouDaoStubImpl() {
        onlyItem = new Item();
        onlyItem.setItemCode("1936");
        onlyItem.setItemName("Rebel Yell");
        onlyItem.setItemPrice(new BigDecimal("1.50").setScale(2, RoundingMode.HALF_UP));
        onlyItem.setItemInventory(Integer.parseInt("5"));

        itemList.add(onlyItem);
    }

    @Override
    public Item createOrder(String itemCode, Item item) throws VMLouPersistenceException, VMLouNotInStockException {
        if (itemCode.equals(onlyItem.getItemCode())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() throws VMLouPersistenceException {
        return itemList;
    }

    @Override
    public Item getItem(String itemCode) {
        if (itemCode.equals(onlyItem.getItemCode())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void editItem(String itemCode, Item item) throws VMLouPersistenceException {
        onlyItem.setItemInventory(item.getItemInventory());
        itemList.remove(0);
        itemList.add(onlyItem);
    }

    @Override
    public Item removeItem(String itemCode) throws VMLouPersistenceException {
        if (itemCode.equals(onlyItem.getItemCode())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void loadInventory() throws VMLouPersistenceException {
//do nothing
    }

    @Override
    public void writeInventory() throws VMLouPersistenceException {
        //nothing
    }
}
