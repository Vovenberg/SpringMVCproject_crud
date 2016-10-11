package com.web.controllers;

import com.web.entities.*;
import com.web.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vladimir on 27.09.2016.
 */
@Controller
public class MainController {

    @Autowired
    ClientsService clientsService;
    @Autowired
    AccountsService accountsService;
    @Autowired
    CardsService cardsService;
    @Autowired
    FilialsService filialsService;
    @Autowired
    OperationsService operationsService;

    @GetMapping(value = "/")
    String getAllTables(ModelMap map){
        List<ClientsEntity> list=clientsService.getAll();
        List<AccountsEntity> list1=accountsService.getAll();
        List<CardsEntity> list2=cardsService.getAll();
        List<FilialsEntity> list3=filialsService.getAll();
        List<OperationsEntity> list4=operationsService.getAll();

        map.addAttribute("clients",list);
        map.addAttribute("accounts",list1);
        map.addAttribute("cards",list2);
        map.addAttribute("fil",list3);
        map.addAttribute("oper",list4);

        return "index";
    }

    @GetMapping(value = "/delete")
    String delete (@RequestParam("option") String option, @RequestParam("id") Long id){
        switch (option){
            case "client":{
                clientsService.delete(id);
                break;
            }
            case "account":{
                accountsService.delete(id);
                break;
            }
            case "card":{
                cardsService.delete(id);
                break;
            }
            case "fil":{
                filialsService.delete(id);
                break;
            }
            case "oper":{
                operationsService.delete(id);
                break;
            }

        }

        return "redirect:/";
    }


}
