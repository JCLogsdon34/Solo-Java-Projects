package com.mycompany.vmlou.service;

import com.mycompany.vmlou.dao.VMLouNotInStockException;
import com.mycompany.vmlou.dto.Change;
import com.mycompany.vmlou.dao.AuditDao;
import com.mycompany.vmlou.dao.VMLouDao;
import com.mycompany.vmlou.dao.VMLouDaoJdbcTemplateImpl;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import com.mycompany.vmlou.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author JCLog
 */
public class ServiceLayerImpl implements ServiceLayer {

    private VMLouDao dao;
    private AuditDao auditDao;
    //maybe this should be private
    public ServiceLayerImpl(VMLouDao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Item addItem(Item item) {
        return dao.addItem(item);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteItem(int itemID) {
        dao.deleteItem(itemID);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateItem(Item item) {
        dao.updateItem(item);
    }

    @Override
    public Item getItemByID(int itemID) {
        return dao.getItemByID(itemID);
    }

    @Override
    public List<Item> getAllItemsInDB() {
        return dao.getAllItemsInDB();
    }

    @Override
    public void createOrder(String itemCode, Item item) throws VMLouNotInStockException, VMLouPersistenceException, VMLouDataValidationException {
        validateItemData(item);
        dao.createOrder(item.getItemCode(), item);
     //   auditDao.writeAuditEntry("Item " + itemCode + " vended");
    }

    @Override
    public BigDecimal enoughMoney(BigDecimal cash, BigDecimal itemPrice) throws VMLouInsufficientFundsException {

        BigDecimal moneyValidate = cash.subtract(itemPrice).setScale(2, RoundingMode.HALF_UP);
        if (moneyValidate.compareTo(BigDecimal.ZERO) < 0) {
            throw new VMLouInsufficientFundsException(                
                    "ERROR: Could not vend item. Here is your money: "
                    + cash.toString()
                    + ", but it is not enough money");
            
        }
        return moneyValidate;
    }

    @Override
    public Change returnChange(BigDecimal itemMoney) {
        BigDecimal conversion = new BigDecimal("100.00").setScale(2);
        BigDecimal changes = itemMoney.multiply(conversion).setScale(2);
        int theRefund = changes.intValueExact();
        return changeRefund(theRefund);
    }

    @Override
    public List<Item> getAllItems() throws VMLouPersistenceException {
        return dao.getAllItems();
    }

    //make this private
    private Change changeRefund(int theRefundInPennies) {
        Change change = new Change();
        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;

        /*
        int numQuarters = theRefundInPennies / 25;
    theRefundInPennies = theRefundInPennies - (numQuarters * 25);
        */
        do {
            if (theRefundInPennies >= 25) {
                int numQuarters = theRefundInPennies / 25;
                change.setNumOfQuarter(numQuarters);
                theRefundInPennies = theRefundInPennies - (numQuarters * 25);
            } else if (theRefundInPennies  >= 10) {
                int numDimes = theRefundInPennies / 10;
                change.setNumOfDime(numDimes);
                theRefundInPennies = theRefundInPennies - 10;
            } else if (theRefundInPennies >= 5) {
                int numNickels = theRefundInPennies / 5;
                change.setNumOfNickel(numNickels);
                theRefundInPennies = theRefundInPennies - 5;
            } else {
                if (theRefundInPennies > 0) {
                    p++;
                    change.setNumOfPenny(p);
                    theRefundInPennies = theRefundInPennies - 1;
                }
            }
        } while (theRefundInPennies > 0);
        return change;
    }

    @Override
    public Item getItem(String itemCode) throws VMLouNotInStockException, VMLouDataValidationException {
        Item currentItem = dao.getItem(itemCode);
        validateItemData(currentItem);

        return dao.getItem(itemCode);
    }

    @Override
    public void editItem(String itemCode, Item item) throws VMLouPersistenceException, VMLouDataValidationException {
        validateItemData(item);
        //auditDao.writeAuditEntry("Item " + itemCode + " edited.");
        dao.editItem(itemCode, item);
    }

    @Override
    public Item removeItem(String itemCode) throws VMLouPersistenceException {
        Item currentItem = dao.removeItem(itemCode);
       // auditDao.writeAuditEntry("Item " + itemCode + " REMOVED.");
        return currentItem;
    }
    
    
    @Override
    public void loadInventory()throws VMLouPersistenceException{
        dao.loadInventory();
    }
    
    @Override
    public void writeInventory()throws VMLouPersistenceException{
        dao.writeInventory();
    }
    

    private void validateItemData(Item item) throws VMLouDataValidationException {
        if (item == null
                || item.getItemCode() == null
                || item.getItemCode().trim().length() == 0
                || item.getItemName() == null
                || item.getItemName().trim().length() == 0) {
            throw new VMLouDataValidationException(
                    "ERROR: Valid item code required to buy item.");
            //issue a refund here?
        }
    }
}
