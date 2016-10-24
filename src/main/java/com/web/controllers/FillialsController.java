package com.web.controllers;

import com.web.entities.FilialsEntity;
import com.web.services.FilialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping("/fil")
public class FillialsController {

    @Autowired
    FilialsService filialsService;

    @GetMapping()
    String getFil(Model model) {
        model.addAttribute("fill", filialsService.getAll());
        return "fillials";
    }

    @GetMapping("/addForm")
    String addJsp(Model model) {
        model.addAttribute("fil", new FilialsEntity());
        return "/forms/addFill";
    }

    @PostMapping("/add")
    String addFil(@Valid @ModelAttribute("fil") FilialsEntity filialsEntity, BindingResult result) {
        if (result.hasErrors()) return "/forms/addFill";
        filialsService.add(filialsEntity);
        return "redirect:/fil";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Long id) {
        filialsService.delete(id);
        return "redirect:/fil";
    }

    @GetMapping("/updateForm")
    String updateForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("fill", filialsService.getById(id));
        return "/forms/editFill";
    }

    @PostMapping("/update")
    String update(@Valid @ModelAttribute("fill") FilialsEntity filialsEntity, BindingResult result) {
        if (result.hasErrors()) return "/forms/editFill";
        filialsService.update(filialsEntity);
        return "redirect:/fil";
    }
}
