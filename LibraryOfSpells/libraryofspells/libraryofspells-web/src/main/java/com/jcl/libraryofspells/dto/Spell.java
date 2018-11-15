/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.libraryofspells.dto;

/**
 *
 * @author JCLog
 */

public class Spell {
    
    private int spellID;
    private String spellName;
    private String spellIncantation;
    private String description;
    private MagicField magicField;

    public int getSpellID() {
        return spellID;
    }

    public void setSpellID(int spellID) {
        this.spellID = spellID;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellIncantation() {
        return spellIncantation;
    }

    public void setSpellIncantation(String spellIncantation) {
        this.spellIncantation = spellIncantation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MagicField getMagicField() {
        return magicField;
    }

    public void setMagicField(MagicField magicField) {
        this.magicField = magicField;
    }
 
    
    
}
