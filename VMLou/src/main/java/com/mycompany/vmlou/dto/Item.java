package com.mycompany.vmlou.dto;

import java.math.BigDecimal;

/**
 *
 * @author JCLog
 */
public class Item {

    private String itemCode;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemInventory;

    public Item(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(int itemInventory) {
        this.itemInventory = itemInventory;
    }

    @Override
    public String toString() {
        return "Item Code: " + itemCode+ " |Name: " + itemName 
                + " |Item Price: " + itemPrice 
                + " |Item Inventory: "+ itemInventory;
    }

}
