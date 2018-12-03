/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.libraryofspells.dao;

import com.jcl.libraryofspells.dto.Spell;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author JCLog
 */
public class SpellsDaoImpl implements SpellsDao {
    
    private JdbcTemplate jdbcTemplate;

    @Inject
    public SpellsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_INSERT_SPELLS
            = "INSERT into spells (spellName, spellIncantation, description, magicFieldID) "
            + "values (?, ?, ?, ?)";
    private static final String SQL_DELETE_SPELLS
            = "DELETE FROM spells WHERE spellID = ? ";
    private static final String SQL_UPDATE_SPELLS
            = "UPDATE spells SET spellName = ?, spellIncantation = ?, description = ?, magicFieldID "
            + "WHERE spellID  =  ?";
    private static final String SQL_SELECT_SPELL_BY_ID
            = "SELECT * FROM spells WHERE spellID = ? ";
    private static final String SQL_SELECT_ALL_SPELLS
            = "SELECT * FROM spells";

    @Override
 //   @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Spell addSpell(Spell Spell) {

        jdbcTemplate.update(SQL_INSERT_SPELLS,
                Spell.getSpellName(),
                Spell.getDescription());

        int SpellID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        Spell.setSpellID(SpellID);
        return Spell;
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSpell(int SpellID) {
 //       jdbcTemplate.update(SQL_DELETE_MAGICFIELD_Spell, SpellID);
        jdbcTemplate.update(SQL_DELETE_SPELLS, SpellID);
    }

    @Override
   // @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSpell(Spell Spell) {
        jdbcTemplate.update(SQL_UPDATE_SPELLS,
                Spell.getSpellName(),
                Spell.getSpellIncantation(),
                Spell.getDescription(),
                Spell.getMagicField(),
                Spell.getSpellID());
    }

    @Override
    public Spell getSpellByID(int spellID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Spell> getAllSpells() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Spell getSpellByID(int SpellID) {
//        try {
//            return jdbcTemplate.queryForObject(SQL_SELECT_SPELL_BY_ID,
//                    new SpellMapper(),
//                    SpellID);
//        } catch (EmptyResultDataAccessException ex) {
//            return null;
//        }
//    }

//    @Override
//    public List<Spell> getAllSpells() {
//        return jdbcTemplate.query(SQL_SELECT_ALL_SPELLS,
//                new SpellMapper());
//    }

    private static final class SpellMapper implements RowMapper<Spell> {

        @Override
        public Spell mapRow(ResultSet rs, int i) throws SQLException {
            Spell pow = new Spell();
            pow.setSpellID(rs.getInt("SpellID"));
            pow.setSpellName(rs.getString("spellName"));
            pow.setSpellIncantation(rs.getString("spellIncantation"));
            pow.setDescription(rs.getString("description"));
            return pow;
        }
    }
    
    
    
}
