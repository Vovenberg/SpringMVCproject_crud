package com.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
