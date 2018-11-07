package com.mycompany.vmlou.userio;

import com.mycompany.vmlou.dto.Item;
import com.mycompany.vmlou.dto.Change;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class View {
    
    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }
    
       public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items in the Inventory");
        io.print("2. Order an Item");
        io.print("3. Exit");

        return io.readInt("Please select from the above choices.", 1, 3);
    }
       
    public String getItemCodeChoice() {
        String itemCode = "";
        itemCode = io.readString("Please enter the item code.");
        return itemCode;
    }
    
       public BigDecimal getMoney(){
          return io.readBigDecimal("Please enter your payment in order to select an item");
       }
       
       public void refundChange(Change change) {
           int q = change.getNumofQuarter();
           int d = change.getNumOfDime();
           int n = change.getNumOfNickel();
           int p = change.getNumOfPenny();
           int i = q + d + n + p;
        io.print("Your refund is: ");
            io.print("quarters: " + Integer.toString(q) + " ");
            io.print("dimes: " + Integer.toString(d) + " ");
            io.print("nickels: " + Integer.toString(n) + " ");
            io.print("pennies: " + Integer.toString(p) + " ");
        if (i <= 0) {
            displayNoChangeDueBanner();
        }
    }
       
       public void displayItem(Item item) {
        if (item != null) {
            io.print(item.getItemCode());
            io.print(item.getItemName());
            io.print(item.getItemPrice().toString());
            io.print(String.valueOf(item.getItemInventory()));
            io.print("");
        } else {
            io.print("No such Item.");
        }
        io.readString("Please hit enter to continue.");
    }
    
       public void displayItem(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getItemCode() + ": "
                        + currentItem.getItemName() + " "
                        + currentItem.getItemPrice() + " "
                        + currentItem.getItemInventory());
        }
        io.readString("Please hit enter to continue.");
    }
    
      public void displaySearchedItems(List<Item> itemList, String itemCode) {

        for (Item currentItem : itemList) {
            if (currentItem.getItemCode().contains(itemCode)) {
                io.print(currentItem.getItemCode() + ": "
                        + currentItem.getItemName() + " "
                        + currentItem.getItemPrice() + " "
                        + currentItem.getItemInventory());
            } else if(currentItem.getItemCode().isEmpty()){
                io.print("No such item in stock");
            }
        }
        io.readString("Please hit enter to continue.");
    } 
    
     public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===");
    }

    public void displayCreateOrderBanner() {
        io.print("=== Create Order ===");
    }
    
    public void displayNoChangeDueBanner() {
        io.print("No change due");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Item Vended.  Please hit enter to continue");
    }

    public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
    }

    public void displayRemoveItemBanner() {
        io.print("=== Remove Item ===");
    }
    
     public void displayNotEnoughMoney(){
        io.print("=== ERROR ===");
        io.print("That is not enough money");
    }
    
    public void displayNotInStock(){
        io.print("=== ERROR ===");
        io.print("Out of Stock");
    }

    public void displayEditItemBanner() {
        io.print("=== Edit Item ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Item successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
