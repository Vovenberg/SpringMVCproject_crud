package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.CardsEntity;
import com.web.entities.ClientsEntity;
import com.web.models.AccModel;
import com.web.models.CardModel;
import com.web.services.AccountsService;
import com.web.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    CardsService cardsService;
    @Autowired
    AccountsService accountsService;

    @GetMapping()
    String getCards(Model model) {
        model.addAttribute("cards", cardsService.getAll());
        return "cards";
    }

    @GetMapping("/addForm")
    String addJsp(Model model) {
        model.addAttribute("card", new CardModel());
        return "/forms/addCards";
    }

    @ModelAttribute("acc")
    List<Long> getClients() {
        return accountsService.getAll().stream().map(AccountsEntity::getIdAccount).collect(Collectors.toList());
    }

    @ModelAttribute("types")
    List<String> getTypes() {
        return Arrays.asList("VISA", "MasterCard");
    }

    @PostMapping("/add")
    String addCard(@Valid @ModelAttribute("card") CardModel model, BindingResult result) {
        AccountsEntity accountsEntity = accountsService.getById(model.getAccountsEntity());
        if (result.hasErrors() || accountsEntity == null) {
            if (accountsEntity == null)
                result.addError(new FieldError("accountsEntity", "accountsEntity", "account with this ID not exist"));
            return "/forms/addCards";
        }
        CardsEntity cardsEntity = new CardsEntity(model.getNumberCard(), model.getVcc(), model.getType(), accountsEntity);
        cardsService.add(cardsEntity);
        return "redirect:/cards";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Long id) {
        cardsService.delete(id);
        return "redirect:/cards";
    }

    @GetMapping("/updateForm")
    String updateForm(@RequestParam("id") Long id, Model model) {
        CardsEntity c = cardsService.getById(id);
        model.addAttribute("card", new CardModel(c.getIdCard(), c.getNumberCard(), c.getVcc(), c.getType(), c.getAccountsEntity().getIdAccount()));
        return "/forms/editCards";
    }

    @PostMapping("/update")
    String update(@Valid @ModelAttribute("card") CardModel c, BindingResult result) {
        if (result.hasErrors()) return "/forms/editCards";
        CardsEntity cardsEntity = new CardsEntity(c.getId(), c.getNumberCard(), c.getVcc(), c.getType(), accountsService.getById(c.getAccountsEntity()));
        cardsService.update(cardsEntity);
        return "redirect:/cards";
    }
}
