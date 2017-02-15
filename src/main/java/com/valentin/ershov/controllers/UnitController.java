package com.valentin.ershov.controllers;

import com.valentin.ershov.domain.Unit;
import com.valentin.ershov.service.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ershov-V-V on 28.12.2016.
 */
@Controller
public class UnitController {
    private UnitServiceImpl unitService;

    @Autowired
    public void setUnitService(UnitServiceImpl unitService) {
        this.unitService = unitService;
    }

    @RequestMapping(value = "/units", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("units", unitService.findAll());
        return "units";
    }

    @RequestMapping("unit/new")
    public String newUnit(Model model) {
        model.addAttribute("unit", new Unit());
        return "unitform";
    }

    @RequestMapping(value = "unit", method = RequestMethod.POST)
    public String saveUnit(Unit unit) {
        unitService.save(unit);
        return "redirect:/unit/" + unit.getId();
    }

    @RequestMapping("unit/{id}")
    public String showUnit(@PathVariable Integer id, Model model) {
        model.addAttribute("unit", unitService.getById(id));
        return "unitshow";
    }

    @RequestMapping("unit/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("unit", unitService.getById(id));
        return "unitform";
    }

    @RequestMapping("unit/delete/{id}")
    public String delete(@PathVariable Integer id) {
        unitService.delete(id);
        return "redirect:/units";
    }
}
