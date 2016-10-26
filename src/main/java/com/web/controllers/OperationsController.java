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
        OperationsEntity operationsEntity = new OperationsEntity(operModel.getDateOper(), operModel.getTypeOper(), entity);
        operationsService.add(operationsEntity);
        return "redirect:/oper";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Long id) {
        operationsService.delete(id);
        return "redirect:/oper";
    }

    @GetMapping("/updateForm")
    String updateForm(@RequestParam("id") Long id, Model model) {
        OperationsEntity o = operationsService.getById(id);
        model.addAttribute("oper", new OperModel(o.getIdOper(), o.getDateOper(), o.getTypeOper(), o.getAccountsEntity().getIdAccount()));
        return "/forms/editOper";
    }

    @PostMapping("/update")
    String update(@Valid @ModelAttribute("oper") OperModel o, BindingResult result) {
        if (result.hasErrors()) return "/forms/editOper";
        OperationsEntity operationsEntity = new OperationsEntity(o.getId(), o.getDateOper(), o.getTypeOper(), accountsService.getById(o.getAccountsEntity()));
        operationsService.update(operationsEntity);
        return "redirect:/oper";
    }
}
