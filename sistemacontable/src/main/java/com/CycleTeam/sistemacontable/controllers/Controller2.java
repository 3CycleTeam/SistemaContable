package com.CycleTeam.sistemacontable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {
    @GetMapping("/julian")
    public String julian() {
        return "indexJulian";
    }



        }
