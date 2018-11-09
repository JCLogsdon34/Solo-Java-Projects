package com.mycompany.vmlou.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JCLog
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Item {

    private int itemID;
    @NotEmpty(message = "You must supply a value for Item Code.")
    @Length(max = 50, message = "Item Code must be no more than 50 characters in length.")    
    private String itemCode;
    @NotEmpty(message = "You must supply a value for itemName.")
    @Length(max = 50, message = "Item Name must be no more than 50 characters in length.")
    private String itemName;
    @NotEmpty(message = "You must supply a value for itemPrice.")
    @Length(max = 50, message = "Item Price must be no more than 50 characters in length.")    
    private BigDecimal itemPrice;
    @NotEmpty(message = "You must supply a value for itemInventory.")
    @Length(max = 50, message = "Item Inventory must be no more than 50 characters in length.")
    private int itemInventory;



    
    @Override
    public String toString() {
        return "Item Code: " + itemCode+ " |Name: " + itemName 
                + " |Item Price: " + itemPrice 
                + " |Item Inventory: "+ itemInventory;
    }

}
