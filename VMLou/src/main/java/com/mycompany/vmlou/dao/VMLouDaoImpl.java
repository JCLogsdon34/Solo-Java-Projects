package com.mycompany.vmlou.dao;

import com.mycompany.vmlou.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class VMLouDaoImpl implements VMLouDao {

    private Map<String, Item> items = new HashMap<>();

    @Override
    public Item createOrder(String itemCode, Item item) throws VMLouNotInStockException, VMLouPersistenceException {
    //    loadInventory();
        updateInventory(itemCode, item);
        items.put(itemCode, item);
        writeInventory();
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        //loadInventory();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(String itemCode) {
        //loadInventory();
        return items.get(itemCode);
    }

    @Override
    public void editItem(String itemCode, Item item) throws VMLouPersistenceException {
        getAllItems();
        items.put(itemCode, item);
        writeInventory();
    }

    @Override
    public Item removeItem(String itemCode) throws VMLouPersistenceException {
        Item removedItem = items.remove(itemCode);
        writeInventory();
        return removedItem;
    }

    //maybe move this method to service
    private void updateInventory(String itemCode, Item item) throws VMLouNotInStockException, VMLouPersistenceException {
        int itemInventory = 0;
        itemInventory = item.getItemInventory();
        if (itemInventory < 1) {
            throw new VMLouNotInStockException("ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        }
        itemInventory = itemInventory - 1;
        item.setItemInventory(itemInventory);
    }

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    @Override
    public void loadInventory() throws VMLouPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VMLouPersistenceException(
                    "-_- Could not load item data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(currentTokens[0]);
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(new BigDecimal(currentTokens[2]).setScale(2, RoundingMode.HALF_UP));
            currentItem.setItemInventory(Integer.parseInt(currentTokens[3]));
            items.put(currentItem.getItemCode(), currentItem);
        }
        scanner.close();
    }

    @Override
    public void writeInventory() throws VMLouPersistenceException {

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VMLouPersistenceException(
                    "Could not save Dvd data.", e);
        }

        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getItemCode() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemInventory());
            out.flush();
        }
        out.close();
    }
}
