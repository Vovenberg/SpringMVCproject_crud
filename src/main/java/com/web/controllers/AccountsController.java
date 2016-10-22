package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.ClientsEntity;
import com.web.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping ("/acc")
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    @GetMapping()
    String getAcc (Model model){
        model.addAttribute("acc",accountsService.getAll());

        return "accounts";
    }
    @GetMapping("/addForm")
    String addJsp (Model model){
        model.addAttribute("acc",new AccountsEntity());
        return "/forms/addAcc";
    }

    @PostMapping("/add")
    String addAcc (@ModelAttribute("acc") AccountsEntity accountsEntity, BindingResult result){
        accountsService.add(accountsEntity);
        return "redirect:/acc";
    }

    @GetMapping("/updateForm")
    String updateForm (@RequestParam("id") Long id, Model model){
        model.addAttribute("acc",accountsService.getById(id));
        return "/forms/editAcc";
    }

    @PostMapping("/update")
    String update (@ModelAttribute("acc") AccountsEntity accountsEntity,BindingResult result){
        accountsService.update(accountsEntity);
        return "redirect:/acc";
    }
}
