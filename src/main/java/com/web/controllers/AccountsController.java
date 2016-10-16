package com.web.controllers;

import com.web.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
