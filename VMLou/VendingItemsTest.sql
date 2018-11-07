DROP DATABASE IF EXISTS VendingItemsTest;

CREATE DATABASE VendingItemsTest;

USE VendingItemsTest;

CREATE TABLE IF NOT EXISTS `bourbons` (
 `bourbonID` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(50) NOT NULL,
 `description` varchar(150) NOT NULL,
 PRIMARY KEY (`superHeroID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `makersmark` (
 `makersID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`makersID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `oldfitzgerald` (
 `fitzID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`fitzID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `mckenna` (
 `mcID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`mckennaID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `oldtaylor` (
 `taylorID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`taylorID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `oldcrow` (
 `crowID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`crowID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `evanwilliams` (
 `williamsID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`williamsID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `kentuckytavern` (
 `tavernID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`tavernID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `heavenhill` (
 `hillID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`hillID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `oldforester` (
 `oldfoID` int(11) NOT NULL,
 `name` varchar(150) NOT NULL,
 `description` varchar(150) NOT NULL,
 `inventory` int(11) NULL,
 PRIMARY KEY (`oldfoID`),
 INDEX `name` (`name`),
 INDEX `description`(`description`),
 INDEX `inventory`(`inventory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;