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

public class Magic {
    private int magicID;
    private String lightOrDark;

    public int getMagicID() {
        return magicID;
    }

    public void setMagicID(int magicID) {
        this.magicID = magicID;
    }

    public String getLightOrDark() {
        return lightOrDark;
    }

    public void setLightOrDark(String lightOrDark) {
        this.lightOrDark = lightOrDark;
    }
    
    
}
