package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.services.EmpleadoService;
import com.CycleTeam.sistemacontable.services.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controllers{
    @Autowired
    EmpresaServicios empresaServicios;

    @Autowired
    EmpleadoService empleadoService;


    @GetMapping ("/Empresas")
    public List<Empresa> listarEmpresas(){
      return empresaServicios.getAllEmpresas();
    }

    @PostMapping("/Empresas")
    public  boolean guardarEmpresa(@RequestBody Empresa empresa){
         return this.empresaServicios.guardarOActualizaEmpresa(empresa);

    }
    @GetMapping ("/Empresas/{id}" )
    public Empresa empresaPorId(@PathVariable Integer id){
       return this.empresaServicios.getEmpresaById(id);

    }
    @PatchMapping ("/Empresas/{id}")
    public boolean  actualizarEmpresa (@PathVariable Integer id, @RequestBody Empresa empresa) {
        Empresa emp= empresaServicios.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNit(empresa.getNit());
        return empresaServicios.guardarOActualizaEmpresa(emp);
    }

    @DeleteMapping ("/Empresas/{id}")
    public String DeleteEmpresa(@PathVariable("id") Integer id){
       boolean respuestas=this.empresaServicios.deleteEmpresa(id);
       if(respuestas){
           return "Se elimio la empresa con Id"+id;
       }
       else {
           return "No se pudo eliminar la empresa con Id"+id;
       }

    }

    //Empleado


    // VER EMPLEADO
    @GetMapping ("/Empleados")
    public List<Empleado> listarEmpleados (){
        return this.empleadoService.listarEmpleados();

    }

    //POST
    @PostMapping("/Empleados")
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
        return Optional.ofNullable(this.empleadoService.guardarOActualizaEmpleado(empleado));
    }
}


