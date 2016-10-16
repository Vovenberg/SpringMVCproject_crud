package com.web.controllers;

import com.web.entities.OperationsEntity;
import com.web.services.AccountsService;
import com.web.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping ("/oper")
public class OperationsController {

    @Autowired
    OperationsService operationsService;

    @GetMapping()
    String getOper (Model model){
        model.addAttribute("oper",operationsService.getAll());

        return "operations";
    }
}
