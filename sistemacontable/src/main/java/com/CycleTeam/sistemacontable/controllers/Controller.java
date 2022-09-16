package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.services.EmpleadoService;
import com.CycleTeam.sistemacontable.services.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

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


    //Agregar empleado
    @PostMapping("/agregarEmpleado")
        public String agregarEmpleado(Empleado nuevoEmpleado){ this.empleadoService.guardarOActualizaEmpleado(nuevoEmpleado);
            return "redirect:/verEmpleados";


        /*@PostMapping("/GuardarEmpleado")
        public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes){
        /*String passEncriptada=passwordEncoder().encode(empl.getPassword());
        empl.setPassword(passEncriptada);
            if(empleadoService.saveOrUpdateEmpleado(empl)==true){
                redirectAttributes.addFlashAttribute("mensaje","saveOK");
                return "redirect:/VerEmpleados";
            }
            redirectAttributes.addFlashAttribute("mensaje","saveError");
            return "redirect:/AgregarEmpleado";*/

        }



}


