/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.spells.spellsservicelayer;

import com.jcl.spells.dto.Spell;
import com.jcl.spells.spellsdao.SpellsDao;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author JCLog
 */
public class SpellsServiceLayerImpl implements SpellsServiceLayer {
    
    private SpellsDao dao;

    @Inject
    public SpellsServiceLayerImpl(SpellsDao dao) {
        this.dao = dao;
    }
    
    @Override
    public Spell addSpell(Spell Spell) {
        return dao.addSpell(Spell);
    }

    @Override
    public void deleteSpell(int SpellID) {
        dao.deleteSpell(SpellID);
    }

    @Override
    public void updateSpell(Spell Spell) {
        dao.updateSpell(Spell);
    }

    @Override
    public Spell getSpellByID(int SpellID) {
        return dao.getSpellByID(SpellID);
    }

    @Override
    public List<Spell> getAllSpells() {
        return dao.getAllSpells();
    }
}
