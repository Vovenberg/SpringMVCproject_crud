package com.web.controllers;

import com.web.entities.ClientsEntity;
import com.web.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Vladimir on 27.09.2016.
 */
@Controller
public class MainController {

    @Autowired
    ClientsService clientsService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    String getAllTables(ModelMap map){
        List<ClientsEntity> list=clientsService.getAll();
        map.addAttribute("clients",list);

        return "index";
    }
}
