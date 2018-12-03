/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.libraryofspells.dao;

import com.jcl.libraryofspells.dto.Spell;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface SpellsDao {
    
    public Spell addSpell(Spell spell);

    public void deleteSpell(int spellID);

    public void updateSpell(Spell spell);

    public Spell getSpellByID(int spellID);

    public List<Spell> getAllSpells();
    
}
