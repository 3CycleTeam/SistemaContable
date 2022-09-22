package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import com.CycleTeam.sistemacontable.entities.Perfil;
import com.CycleTeam.sistemacontable.services.EmpleadoService;
import com.CycleTeam.sistemacontable.services.EmpresaServicios;
import com.CycleTeam.sistemacontable.services.MoviDinerService;
import com.CycleTeam.sistemacontable.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    EmpresaServicios empresaServicios;

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    PerfilService perfilService;
    @Autowired
    MoviDinerService movimientosService;

    // *****INICIO CONTROLLER EMPRESA*****


    //Mostrar Empresa
    @GetMapping("/empresas/mostrar")

    public String mostrarempresas( Model model ) {
        List<Empresa> listaempresas = this.empresaServicios.getAllEmpresas();
        model.addAttribute("listaempresas",listaempresas);
        return "showenterprises";
    }

    //Agregar Empresa
    @GetMapping("/agregarempresas")
    public String agregarEmpresas(Model model){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        return "addEnterprises";
    }

    //Guardar Empresa
    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes ){
        this.empresaServicios.guardarOActualizaEmpresa(emp);
        return "redirect:/empresas/mostrar";
    }

    //Editar Empresa
    @GetMapping("/editarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id ){
        Empresa emp = empresaServicios.getEmpresaById(id);
        model.addAttribute("emp",emp);
        return "editEnterprises";
    }

    //Actualizar Empresa
    @PostMapping("/actualizarEmpresa")
    public String ActualizarEmpresa(Empresa emp, RedirectAttributes redirectAttributes ) {
        this.empresaServicios.guardarOActualizaEmpresa(emp);
        return "redirect:/empresas/mostrar";
    }

    @GetMapping("/eliminarEmpresa/{id}")

    public String eliminarEmpresa(@PathVariable Integer id){

        Empresa emp = empresaServicios.getEmpresaById(id);
        empresaServicios.deleteEmpresa(id);
        return "redirect:/empresas/mostrar";
    }



    // *****INICIO CONTROLLER EMPLEADO*****



    // Mostrar empleados
    @GetMapping ("/Empleados")
    public String mostrarempleados( Model model ) {
        List<Empleado> listarEmpleados = this.empleadoService.listarEmpleados();
        model.addAttribute("listarEmpleados",listarEmpleados);
        return "verEmpleados";
    }

    // Agregar empleado
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado nuevoEmpleado){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedcont = bCryptPasswordEncoder.encode(nuevoEmpleado.getContrasena());
        nuevoEmpleado.setContrasena(hashedcont);
        this.empleadoService.guardarOActualizaEmpleado(nuevoEmpleado);
        return "redirect:/Empleados";
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

    // Eliminar empleado
    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado (@PathVariable Integer id){
        Optional<Empleado> empleadoUno = empleadoService.getEmpleadoById(id);
        empleadoService.deleteEmpleado(id);
        return "redirect:/Empleados";
    }


    @GetMapping("/empleadosxempresa")
    public String verEmpleadosPorEmpresa(Model model ){
        List<Empresa> listaEmpresas= this.empresaServicios.getAllEmpresas();
        model.addAttribute("listaEmpresas",listaEmpresas);

        return "verEmpleadosEmpresa";
    }

    @GetMapping ("/empleadosxempresa/{id}")
    public String mostrarempleadosPorEmpresa( Model model,@PathVariable int id ) {
        Empresa empresa = this.empresaServicios.getEmpresaById(id);
        System.out.println(empresa.getNombre());
        List<Empleado> listarEmpleados = this.empleadoService.empleadosByEmpresa(empresa);
        model.addAttribute("listarEmpleados",listarEmpleados);
        return "verEmpleados";
    }

    //Editar Empleado
    @GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Integer id ){
        Optional<Empleado> empleado = this.empleadoService.getEmpleadoById(id);
        List<Empresa> listaEmpresas= this.empresaServicios.getAllEmpresas();
        List<Perfil> listaPerfiles=this.perfilService.getPerfiles();
        model.addAttribute("empleado",empleado);
        model.addAttribute("listaPerfiles",listaPerfiles);
        model.addAttribute("listaEmpresas",listaEmpresas);
        return "editUsers";
    }

    @PostMapping("/actualizarEmpleado")
    public String ActualizarEmpleado(Empleado empleado, RedirectAttributes redirectAttributes ) {
        this.empleadoService.guardarOActualizaEmpleado(empleado);
        return "redirect:/Empleados";
    }

    // *****INICIO CONTROLLER MOVIMIENTO DINERO*****


    //Agregar Movimiento de Dinero
    @GetMapping("/agregarmovimientos")
    public String agregarMovimientos(Model model){
        MovimientoDinero movimiento= new MovimientoDinero();
        List<Empresa> listaEmpresas = this.empresaServicios.getAllEmpresas();
        List<Empleado> listaEmpleados= this.empleadoService.listarEmpleados();
        model.addAttribute("movimiento",movimiento);
        model.addAttribute("listaEmpleados",listaEmpleados);
        model.addAttribute("listaEmpresas",listaEmpresas);
        return "addMoves";
    }

    @GetMapping("verMovimientos")
    public String mostrarMovimientos (Model model){
        List<MovimientoDinero> listaMovimientos = this.movimientosService.getAllMovimientoDinero();
        model.addAttribute("listaMovimientos",listaMovimientos);
        return"verMovimientos";
    }



    //////////////////////////////////////////////////////////////////////////////
    @GetMapping("/editarMovimiento/{id}")
    public String editarMovimiento(Model model, @PathVariable Integer id ){
        MovimientoDinero movimiento = this.movimientosService.buscarMoviDinerbyId(id);
        List<Empresa> listaEmpresas = this.empresaServicios.getAllEmpresas();
        List<Empleado> listaEmpleados= this.empleadoService.listarEmpleados();
        model.addAttribute("movimiento",movimiento);
        model.addAttribute("listaEmpleados",listaEmpleados);
        model.addAttribute("listaEmpresas",listaEmpresas);

        return "editarMovimiento";
    }

    //Actualizar Movimiento
    @PostMapping("/actualizarMovimiento")
    public String ActualizarEmpresa(MovimientoDinero movimiento) {

        this.movimientosService.guardarOActualizarMovimiento(movimiento);
        return "redirect:/verMovimientos";
    }
    //////////////////////////////////////////////////////////////////////////////


}

