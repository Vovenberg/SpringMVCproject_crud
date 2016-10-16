package com.web.controllers;

import com.web.services.AccountsService;
import com.web.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping ("/cards")
public class CardsController {
    @Autowired
    CardsService cardsService;

    @GetMapping()
    String getCards (Model model){
        model.addAttribute("cards",cardsService.getAll());

        return "cards";
    }

}
