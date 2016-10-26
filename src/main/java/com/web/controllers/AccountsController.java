package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.ClientsEntity;
import com.web.entities.FilialsEntity;
import com.web.models.AccModel;
import com.web.services.AccountsService;
import com.web.services.ClientsService;
import com.web.services.FilialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vladimir on 16.10.2016.
 */
@Controller
@RequestMapping("/acc")
public class AccountsController {

    @Autowired
    AccountsService accountsService;
    @Autowired
    ClientsService clientsService;
    @Autowired
    FilialsService filialsService;

    @GetMapping()
    String getAcc(Model model) {
        model.addAttribute("acc", accountsService.getAll());
        return "accounts";
    }

    @GetMapping("/addForm")
    String addJsp(Model model) {
        model.addAttribute("acc", new AccModel());
        return "/forms/addAcc";
    }

    @ModelAttribute("fills")
    List<Long> getFills() {
        return filialsService.getAll().stream().map(FilialsEntity::getIdFilial).collect(Collectors.toList());
    }

    @ModelAttribute("clients")
    List<Long> getClients() {
        return clientsService.getAll().stream().map(ClientsEntity::getIdClient).collect(Collectors.toList());
    }

    @PostMapping("/add")
    String addAcc(@Valid @ModelAttribute("acc") AccModel accModel, BindingResult result) {
        ClientsEntity clientsEntity = clientsService.getById(accModel.getClientsEntity());
        FilialsEntity filialsEntity = filialsService.getById(accModel.getFilialsEntity());
        if (result.hasErrors() || clientsEntity == null || filialsEntity == null) {
            if (clientsEntity == null)
                result.addError(new FieldError("clientsEntity", "clientsEntity", "client not exist"));
            if (filialsEntity == null)
                result.addError(new FieldError("filialsEntity", "filialsEntity", "filial not exist"));
            return "/forms/addAcc";
        }
        AccountsEntity accountsEntity = new AccountsEntity(accModel.getDateBegin(), accModel.getDateClose(), filialsEntity, clientsEntity);
        accountsService.add(accountsEntity);
        return "redirect:/acc";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Long id) {
        accountsService.delete(id);
        return "redirect:/acc";
    }

    @GetMapping("/updateForm")
    String updateForm(@RequestParam("id") Long id, Model model) {
        AccountsEntity accountsEntity = accountsService.getById(id);

        model.addAttribute("acc", new AccModel(accountsEntity.getIdAccount(), accountsEntity.getDateBegin(), accountsEntity.getDateClose(), accountsEntity.getFilialsEntity().getIdFilial(), accountsEntity.getClientsEntity().getIdClient()));
        return "/forms/editAcc";
    }

    @PostMapping("/update")
    String update(@Valid @ModelAttribute("acc") AccModel accModel, BindingResult result) {
        if (result.hasErrors()) return "/forms/editAcc";
        AccountsEntity accountsEntity = new AccountsEntity(accModel.getId(), accModel.getDateBegin(), accModel.getDateClose(), clientsService.getById(accModel.getClientsEntity()), filialsService.getById(accModel.getFilialsEntity()));
        accountsService.update(accountsEntity);
        return "redirect:/acc";
    }
}
