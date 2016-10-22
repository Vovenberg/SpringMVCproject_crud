package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.CardsEntity;
import com.web.entities.ClientsEntity;
import com.web.services.AccountsService;
import com.web.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/addForm")
    String addJsp (Model model){
        model.addAttribute("card",new CardsEntity());
        return "/forms/addCards";
    }

    @PostMapping("/add")
    String addCard (@ModelAttribute("card") CardsEntity cardsEntity, BindingResult result){
        cardsService.add(cardsEntity);
        return "redirect:/cards";
    }

    @GetMapping("/updateForm")
    String updateForm (@RequestParam("id") Long id, Model model){
        model.addAttribute("card",cardsService.getById(id));
        return "/forms/editCards";
    }

    @PostMapping("/update")
    String update (@ModelAttribute("card") CardsEntity cardsEntity, BindingResult result){
        cardsService.update(cardsEntity);
        return "redirect:/cards";
    }
}
