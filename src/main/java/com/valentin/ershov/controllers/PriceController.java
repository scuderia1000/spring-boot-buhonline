package com.valentin.ershov.controllers;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.service.PriceServiceImpl;
import com.valentin.ershov.service.UnitServiceImpl;
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
//    private Repository<Price, Integer> priceService;
    private PriceServiceImpl priceService;
    private UnitServiceImpl unitService;

    @Autowired
    public void setUnitService(UnitServiceImpl unitService) {
        this.unitService = unitService;
    }

    @Autowired
    public void setPriceService(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

//    @Autowired
//    public void setPriceService(Repository<Price, Integer> repository) {
//        this.priceService = repository;
//    }

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("prices", priceService.findAll());
        return "prices";
    }

    @RequestMapping("price/new")
    public String newPrice(Model model) {
        model.addAttribute("price", new Price());
        model.addAttribute("units", unitService.findAll());
        model.addAttribute("prices", priceService.findAll());
        return "priceform";
    }

    @RequestMapping(value = "price", method = RequestMethod.POST)
    public String savePrice(Price price) {
        priceService.save(price);
        return "redirect:/price/" + price.getId();
    }

    @RequestMapping("price/{id}")
    public String showPrice(@PathVariable Integer id, Model model) {
        model.addAttribute("price", priceService.getById(id));
        return "priceshow";
    }

    @RequestMapping("price/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("price", priceService.getById(id));
        model.addAttribute("units", unitService.findAll());
        return "priceform";
    }

    @RequestMapping("price/delete/{id}")
    public String delete(@PathVariable Integer id) {
        priceService.delete(id);
        return "redirect:/prices";
    }


}
