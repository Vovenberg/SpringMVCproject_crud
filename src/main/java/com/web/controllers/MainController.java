package com.web.controllers;

import com.web.entities.*;
import com.web.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Vladimir on 27.09.2016.
 */
@Controller
public class MainController {

    @GetMapping("/")
    String index() {
        return "index";
    }
}
