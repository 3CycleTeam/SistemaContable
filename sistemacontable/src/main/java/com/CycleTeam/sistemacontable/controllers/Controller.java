package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.entities.Perfil;
import com.CycleTeam.sistemacontable.services.EmpleadoService;
import com.CycleTeam.sistemacontable.services.EmpresaServicios;
import com.CycleTeam.sistemacontable.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    EmpresaServicios empresaServicios;

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    PerfilService perfilService;


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
    public String agregarEmpresas(Model model){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        return "addEnterprises";
    }
    @GetMapping("/agregarempleados")
    public String agregarEmpleados(Model model ){
        Empleado nuevoEmpleado= new Empleado();
        List<Empresa> listaEmpresas= this.empresaServicios.getAllEmpresas();
        List<Perfil> listaPerfiles= this.perfilService.getPerfiles();
        model.addAttribute("nuevoEmpleado",nuevoEmpleado);
        model.addAttribute("listaEmpresas",listaEmpresas);
        model.addAttribute("listaPerfiles",listaPerfiles);
        return "addUsers";

    }

    @GetMapping("/agregarmovimientos")
    public String agregarMovimientos(){
        return "addMoves";
    }


    //Agregar empleado
    @PostMapping("/agregarEmpleado")
        public String agregarEmpleado(Empleado nuevoEmpleado){
        this.empleadoService.guardarOActualizaEmpleado(nuevoEmpleado);
            return "redirect:/verEmpleados";
        }

    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes ){
        this.empresaServicios.guardarOActualizaEmpresa(emp);
        return "redirect:/empresas/mostrar";
    }

    @GetMapping("/editarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id ){
        Empresa emp = empresaServicios.getEmpresaById(id);
        model.addAttribute("emp",emp);
        return "editEnterprises";

    }
    @PostMapping("/actualizarEmpresa")
    public String ActualizarEmpresa(Empresa emp, RedirectAttributes redirectAttributes ) {
        this.empresaServicios.guardarOActualizaEmpresa(emp);
        return "redirect:/empresas/mostrar";
    }

    @GetMapping("/eliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id ){
        Empresa emp = empresaServicios.getEmpresaById(id);
        empresaServicios.deleteEmpresa(id);
        return "redirect:/empresas/mostrar";
    }

    }

