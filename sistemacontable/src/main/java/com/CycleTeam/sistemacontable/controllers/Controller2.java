package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.services.EmpleadoService;
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

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empresas/mostrar")

    public String mostrarempresas( Model model ) {
        List<Empresa> listaempresas = this.empresaServicios.getAllEmpresas();
        model.addAttribute("listaempresas",listaempresas);
        return "showenterprises";   }

    @GetMapping ("/Empleados")
    public String mostrarempleados( Model model ) {

        List<Empleado> listarEmpleados = this.empleadoService.listarEmpleados();
        model.addAttribute("listarEmpleados",listarEmpleados);
        return "verEmpleados";   }

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


