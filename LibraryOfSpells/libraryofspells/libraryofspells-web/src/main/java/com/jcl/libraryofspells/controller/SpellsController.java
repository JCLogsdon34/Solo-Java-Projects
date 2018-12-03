/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.libraryofspells.controller;

import com.jcl.libraryofspells.dto.MagicField;
import com.jcl.libraryofspells.dto.Spell;
import com.jcl.libraryofspells.servicelayer.SpellsServiceLayer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author JCLog
 */
@Controller
public class SpellsController {
    
    private SpellsServiceLayer service;

    @Inject
    public SpellsController(SpellsServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLandingPage() {
        return "index";
    }
 
    @RequestMapping(value = "/displaySpellsPage", method = RequestMethod.GET)
    public String displayAllSpells(Model model) {
        List<Spell> SpellList = new ArrayList<>();
        SpellList = service.getAllSpells();
        model.addAttribute("SpellList", SpellList);
        return "SpellsPage";
    }

    @RequestMapping(value = "/createSpell", method = RequestMethod.POST)
    public String createSpell(HttpServletRequest request) {
        Spell Spell = new Spell();
        Spell.setSpellName(request.getParameter("name"));
        Spell.setSpellIncantation(request.getParameter("spellIncantation"));
        Spell.setDescription(request.getParameter("description"));
//        Spell.setMagicField(request.getParameter("magicField"));
        service.addSpell(Spell);
        return "redirect:displaySpellsPage";
    }

    @RequestMapping(value = "/displayUpdateSpell", method = RequestMethod.GET)
    public String displayEditSpellForm(HttpServletRequest request, Model model) {
        List<Spell> SpellList = new ArrayList<>();
        String SpellIdParameter = request.getParameter("SpellID");
        int SpellID = Integer.parseInt(SpellIdParameter);
        Spell Spell = new Spell();
        Spell = service.getSpellByID(SpellID);
        SpellList.add(Spell);
        model.addAttribute("SpellList", SpellList);
        return "updateSpellForm";
    }

    @RequestMapping(value = "/updateSpell", method = RequestMethod.POST)
    public String editSpell(@Valid @ModelAttribute("SpellList") Spell Spell, BindingResult result) {
        if (result.hasErrors()) {
            return "updateSpellForm";
        }
        service.updateSpell(Spell);
        return "redirect:SpellsPage";
    }

    @RequestMapping(value = "/deleteSpell", method = RequestMethod.GET)
    public String deleteSpell(HttpServletRequest request) {
        String SpellIdParameter = request.getParameter("SpellID");
        int SpellID = Integer.parseInt(SpellIdParameter);
        service.deleteSpell(SpellID);
        return "redirect:displaySpellsPage";
    }

    @RequestMapping(value = "/displaySpell", method = RequestMethod.GET)
    public String displaySpell(HttpServletRequest request, Model model) {
        List<Spell> SpellList = new ArrayList<>();
        String SpellIdParameter = request.getParameter("SpellID");
        int SpellID = Integer.parseInt(SpellIdParameter);
        Spell Spell = new Spell();
        Spell = service.getSpellByID(SpellID);
        SpellList.add(Spell);
        model.addAttribute("SpellList", SpellList);
        return "SpellDetails";
    }
    
    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    /////////////////////Magic Field ///////////////////////////
    /////////////////////////////////////////////////////////////
    

    @RequestMapping(value = "/deleteMagicField", method = RequestMethod.GET)
    public String deleteMagicField(HttpServletRequest request) {
        String magicFieldIdParameter = request.getParameter("magicFieldID");
        int magicFieldID = Integer.parseInt(magicFieldIdParameter);
  //      service.deleteMagicField(magicFieldID);
        return "redirect:displayMagicFieldsPage";
    }

    @RequestMapping(value = "/displayMagicField", method = RequestMethod.GET)
    public String displayMagicField(HttpServletRequest request, Model model) {
        List<MagicField> magicFieldList = new ArrayList<>();
        String magicFieldIdParameter = request.getParameter("magicFieldID");
        int magicFieldID = Integer.parseInt(magicFieldIdParameter);
        MagicField magicField = new MagicField();
   //     magicField = service.getMagicFieldByID(magicFieldID);
        magicFieldList.add(magicField);
        model.addAttribute("magicFieldList", magicFieldList);
        return "MagicFieldDetails";
    }
    
}
