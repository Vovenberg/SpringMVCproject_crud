package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.ClientsEntity;
import com.web.entities.OperationsEntity;
import com.web.services.AccountsService;
import com.web.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/addForm")
    String addJsp (Model model){
        model.addAttribute("oper",new OperationsEntity());
        return "/forms/addOper";
    }

    @PostMapping("/add")
    String addOper (@ModelAttribute("oper") OperationsEntity operationsEntity, BindingResult result){
        operationsService.add(operationsEntity);
        return "redirect:/oper";
    }
    @GetMapping("/updateForm")
    String updateForm (@RequestParam("id") Long id, Model model){
        model.addAttribute("oper",operationsService.getById(id));
        return "/forms/editClients";
    }

    @PostMapping("/update")
    String update (@ModelAttribute("oper") OperationsEntity operationsEntity, BindingResult result){
        operationsService.update(operationsEntity);
        return "redirect:/clients";
    }
}
