package com.web.controllers;

import com.web.entities.AccountsEntity;
import com.web.entities.OperationsEntity;
import com.web.models.OperModel;
import com.web.services.AccountsService;
import com.web.services.OperationsService;
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
@RequestMapping("/oper")
public class OperationsController {

    @Autowired
    OperationsService operationsService;
    @Autowired
    AccountsService accountsService;

    @GetMapping()
    String getOper(Model model) {
        model.addAttribute("oper", operationsService.getAll());
        return "operations";
    }

    @GetMapping("/addForm")
    String addJsp(Model model) {
        model.addAttribute("oper", new OperationsEntity());
        return "/forms/addOper";
    }

    @ModelAttribute("acc")
    List<Long> getClients() {
        return accountsService.getAll().stream().map(AccountsEntity::getIdAccount).collect(Collectors.toList());
    }

    @PostMapping("/add")
    String addOper(@Valid @ModelAttribute("oper") OperModel operModel, BindingResult result) {
        AccountsEntity entity = accountsService.getById(operModel.getAccountsEntity());
        if (result.hasErrors() || entity == null) {
            if (entity == null)
                result.addError(new FieldError("accountsEntity", "accountsEntity", "account with this ID not exist"));
            return "/forms/addOper";
        }
        OperationsEntity operationsEntity = new OperationsEntity();
        operationsEntity.setDateOper(operModel.getDateOper());
        operationsEntity.setTypeOper(operModel.getTypeOper());
        operationsEntity.setAccountsEntity(entity);
        operationsService.add(operationsEntity);
        return "redirect:/oper";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Long id) {
        operationsService.delete(id);
        return "redirect:/oper";
    }

    @GetMapping("/updateForm")
    String updateForm(@Valid @RequestParam("id") Long id, Model model) {
        model.addAttribute("oper", operationsService.getById(id));
        return "/forms/editOper";
    }

    @PostMapping("/update")
    String update(@ModelAttribute("oper") OperationsEntity operationsEntity, BindingResult result) {
        if (result.hasErrors()) return "/forms/editOper";
        operationsService.update(operationsEntity);
        return "redirect:/clients";
    }
}
