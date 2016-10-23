package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.ClientsEntity;
import com.web.services.AccountsService;
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
    String addAcc (@Valid @ModelAttribute("acc") AccountsEntity accountsEntity, BindingResult result){
        if (result.hasErrors())
            return "/forms/addAcc";
        accountsService.add(accountsEntity);
        return "redirect:/acc";
    }

    @GetMapping("/delete")
    String delete (@RequestParam("id") Long id){
        accountsService.delete(id);
        return "redirect:/acc";
    }

    @GetMapping("/updateForm")
    String updateForm (@RequestParam("id") Long id, Model model){
        model.addAttribute("acc",accountsService.getById(id));
        return "/forms/editAcc";
    }

    @PostMapping("/update")
    String update (@Valid @ModelAttribute("acc") AccountsEntity accountsEntity, BindingResult result){
        if (result.hasErrors())
            return "/forms/editAcc";
        accountsService.update(accountsEntity);
        return "redirect:/acc";
    }
}
