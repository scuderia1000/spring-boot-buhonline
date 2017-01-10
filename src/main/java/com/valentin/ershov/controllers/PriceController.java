package com.valentin.ershov.controllers;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.service.PriceService;
import com.valentin.ershov.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Controller
public class PriceController {
    private PriceService priceService;
    private UnitService unitService;

    @Autowired
    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }

    @Autowired
    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("prices", priceService.listAllPrices());
        return "prices";
    }

    @RequestMapping("price/new")
    public String newPrice(Model model) {
        model.addAttribute("price", new Price());
        model.addAttribute("units", unitService.listAllUnits());
        return "priceform";
    }

    @RequestMapping(value = "price", method = RequestMethod.POST)
    public String savePrice(Price price) {
        priceService.savePrice(price);
        return "redirect:/price/" + price.getId();
    }

    @RequestMapping("price/{id}")
    public String showPrice(@PathVariable Integer id, Model model) {
        model.addAttribute("price", priceService.getPriceById(id));
        return "priceshow";
    }

    @RequestMapping("price/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("price", priceService.getPriceById(id));
        model.addAttribute("units", unitService.listAllUnits());
        return "priceform";
    }

    @RequestMapping("price/delete/{id}")
    public String delete(@PathVariable Integer id) {
        priceService.deletePrice(id);
        return "redirect:/prices";
    }
}
