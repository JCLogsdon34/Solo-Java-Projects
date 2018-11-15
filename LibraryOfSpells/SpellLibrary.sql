DROP DATABASE IF EXISTS SpellLibrary;

CREATE DATABASE SpellLibrary;

USE SpellLibrary;

CREATE TABLE IF NOT EXISTS `magics` (
 `magicID` int(11) NOT NULL AUTO_INCREMENT,
 `magicName` varchar(50) NOT NULL,
 PRIMARY KEY (`magicID`),
 INDEX `name` (`magicName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `magicfields` (
 `magicFieldID` int(11) NOT NULL AUTO_INCREMENT,
 `magicFieldName` varchar(50) NOT NULL,
 `magic` int(11) NOT NULL,
 PRIMARY KEY (`magicFieldID`),
 INDEX `magicFieldName`(`magicFieldName`),
 KEY `magic_idx` (`magic`),
 CONSTRAINT `fk_magicfields_magics` FOREIGN KEY (`magic`) REFERENCES `magics`(`magicID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `spells` (
 `spellID` int(11) NOT NULL AUTO_INCREMENT,
 `spellName` varchar(150) NOT NULL,
 `spellIncantation` varchar(150) NOT NULL,
 `description` varchar(250) NOT NULL,
 `magicField` int(11) NOT NULL,
 PRIMARY KEY (`spellID`),
 INDEX `spellName`(`spellName`),
 INDEX `spellIncantation`(`spellIncantation`),
 INDEX `description`(`description`),
 KEY `magicField_idx` (`magicField`),
 CONSTRAINT `fk_spells_magicFields` FOREIGN KEY (`magicField`) REFERENCES `magicfields`(`magicFieldID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;