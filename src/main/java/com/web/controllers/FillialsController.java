package com.web.controllers;

import com.web.services.AccountsService;
import com.web.services.FilialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping ("/fil")
public class FillialsController {

    @Autowired
    FilialsService filialsService;

    @GetMapping()
    String getFil (Model model){
        model.addAttribute("fill",filialsService.getAll());

        return "fillials";
    }
}