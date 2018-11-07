package com.mycompany.vmlou.controller;

import com.mycompany.vmlou.dao.VMLouNotInStockException;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import com.mycompany.vmlou.dto.Item;
import com.mycompany.vmlou.dto.Change;
import com.mycompany.vmlou.service.ServiceLayer;
import com.mycompany.vmlou.service.VMLouDataValidationException;
import com.mycompany.vmlou.service.VMLouInsufficientFundsException;
import com.mycompany.vmlou.userio.View;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author JCLog
 */
public class Controller {

    private View view;
    private ServiceLayer service;

    public Controller(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                loadInventory();
                listItems();

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        createOrder();
                        break;
                    case 3:
                        writeInventory();
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VMLouPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void loadInventory() throws VMLouPersistenceException {
        service.loadInventory();
    }

    private void writeInventory() throws VMLouPersistenceException {
        service.writeInventory();
    }

    private void createOrder() throws VMLouPersistenceException {
        boolean keepBoolingAround = true;
        String itemCode = "";
        BigDecimal changeRefund = new BigDecimal("0");
        BigDecimal money = new BigDecimal("0");
        Item currentItem = new Item(itemCode);
        Change change = new Change();
        do {
            view.displayCreateOrderBanner();
            money = view.getMoney();
            try {
                itemCode = view.getItemCodeChoice();
                currentItem = service.getItem(itemCode);
            } catch (VMLouDataValidationException e) {
                view.displayErrorMessage(itemCode);
                change = service.returnChange(money);
                view.refundChange(change);
                break;
            } catch (VMLouNotInStockException e) {
                view.displayErrorMessage(itemCode);
                change = service.returnChange(money);
                view.refundChange(change);
                break;
            }

            try {
                changeRefund = service.enoughMoney(money, currentItem.getItemPrice());
            } catch (VMLouInsufficientFundsException e) {
                view.displayNotEnoughMoney();
                change = service.returnChange(money);
                view.refundChange(change);
                break;
            }

            try {
                service.createOrder(itemCode, currentItem);
                view.displayCreateSuccessBanner();
            } catch (VMLouNotInStockException e) {
                view.displayNotInStock();
                change = service.returnChange(money);
                view.refundChange(change);
                break;
            } catch (VMLouDataValidationException e) {
                view.displayErrorMessage(e.getMessage());
                change = service.returnChange(money);
                view.refundChange(change);
                break;
            }
            exitMessage();
            keepBoolingAround = false;
        } while (keepBoolingAround);
    }

    private void listItems() throws VMLouPersistenceException {
        view.displayDisplayAllBanner();
        List<Item> itemList = service.getAllItems();
        view.displayItem(itemList);
    }

    /*
    private void getItem()throws VMLouDataValidationException,
            VMLouNotInStockException {
            String itemCode = "";
            Item currentItem = new Item(itemCode);
            view.displayDisplayItemBanner();
            try {
                itemCode = view.getItemCodeChoice();
                currentItem = service.getItem(itemCode);
            } catch (VMLouNotInStockException e) {
                view.displayErrorMessage(itemCode);
                break;
            } 
            view.displayItem(currentItem);
    }
    
    private void editItem() throws VMLouPersistenceException,
            VMLouDataValidationException{
            String itemCode = "";
            Item currentItem = new Item(itemCode);
            view.displayEditItemBanner();
            itemCode = view.getItemCodeChoice();
            currentItem = service.getItem(itemCode);
            //add a new menu to implement this fully
            view.displayItem(currentItem);
            service.editItem(itemCode, currentItem);
            
    }

    private void removeItem()throws VMLouPersistenceException{
            String itemCode = "";
            Item currentItem = new Item(itemCode);
            view.displayRemoveItemBanner();
            itemCode = view.getItemCodeChoice();
            currentItem = service.removeItem(itemCode);
            view.displayItem(currentItem);
            view.displayRemoveSuccessBanner();
    }
     */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
