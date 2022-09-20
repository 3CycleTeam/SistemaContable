package com.CycleTeam.sistemacontable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping (name = "/")
    public String index (){

        return "index";
    }

}
