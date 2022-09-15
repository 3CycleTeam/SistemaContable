package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.services.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Controller2 {

    @Autowired
    EmpresaServicios empresaServicios;
    @GetMapping()
    public String index(){
        return "index";
    }
    @GetMapping("/mostrarempresas")
    public String mostrarempresas( Model model ) {
        List<Empresa> listaempresas = this.empresaServicios.getAllEmpresas();
        model.addAttribute("listaempresas",listaempresas);
        return "showenterprises";   }

    @GetMapping("/agregarempresas")
    public String agregarEmpresas(){
        return "addEnterprises";
    }
    @GetMapping("/agregarempleados")
    public String agregarEmpleados(){
        return "addUsers";
    }

    @GetMapping("/agregarmovimientos")
    public String agregarMovimientos(){
        return "addMoves";
    }



        }


