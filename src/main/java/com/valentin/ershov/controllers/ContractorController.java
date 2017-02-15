package com.valentin.ershov.controllers;

import com.valentin.ershov.domain.Contractor;
import com.valentin.ershov.service.ContractorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Valek on 16.02.2017.
 */
@Controller
public class ContractorController {
    private ContractorServiceImpl contractorService;

    @Autowired
    public void setContractorService(ContractorServiceImpl contractorService) {
        this.contractorService = contractorService;
    }

    @RequestMapping(value = "/contractors", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contractors", contractorService.findAll());
        return "contractors";
    }

    @RequestMapping("contractor/new")
    public String newContractor(Model model) {
        model.addAttribute("contractor", new Contractor());
        return "contractorform";
    }

    @RequestMapping(value = "contractor", method = RequestMethod.POST)
    public String saveContractor(Contractor contractor) {
        contractorService.save(contractor);
        return "redirect:/contractor/" + contractor.getId();
    }

    @RequestMapping("contractor/{id}")
    public String showContractor(@PathVariable Integer id, Model model) {
        model.addAttribute("contractor", contractorService.getById(id));
        return "contractorshow";
    }

    @RequestMapping("contractor/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contractor", contractorService.getById(id));
        return "contractorform";
    }

    @RequestMapping("contractor/delete/{id}")
    public String delete(@PathVariable Integer id) {
        contractorService.delete(id);
        return "redirect:/contractors";
    }
}
