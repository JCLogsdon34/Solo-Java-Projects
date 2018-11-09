DROP DATABASE IF EXISTS VendingItems;

CREATE DATABASE VendingItems;

USE VendingItems;

CREATE TABLE IF NOT EXISTS `Items` (
 `itemID` int(11) NOT NULL AUTO_INCREMENT,
 `itemCode` varchar(50) NOT NULL,
 `itemName` varchar(50) NOT NULL,
 `itemPrice` FIXED(4,2) UNSIGNED NULL,
 `itemInventory` int(11) NOT NULL,
 PRIMARY KEY (`itemID`),
 INDEX `itemCode`(`itemCode`),
 INDEX `itemName` (`itemName`),
 INDEX `itemPrice`(`itemPrice`),
 INDEX `itemInventory`(`itemInventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



