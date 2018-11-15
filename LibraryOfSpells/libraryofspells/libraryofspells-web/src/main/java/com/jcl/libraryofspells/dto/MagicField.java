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

public class MagicField {
    private int magicFieldID;
    private String magicFieldName;
    private Magic magic;

    public int getMagicFieldID() {
        return magicFieldID;
    }

    public void setMagicFieldID(int magicFieldID) {
        this.magicFieldID = magicFieldID;
    }

    public String getMagicFieldName() {
        return magicFieldName;
    }

    public void setMagicFieldName(String magicFieldName) {
        this.magicFieldName = magicFieldName;
    }

    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        this.magic = magic;
    }
    
    
}
