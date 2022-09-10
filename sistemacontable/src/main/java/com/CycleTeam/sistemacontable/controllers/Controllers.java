package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import com.CycleTeam.sistemacontable.services.EmpleadoService;
import com.CycleTeam.sistemacontable.services.EmpresaServicios;
import com.CycleTeam.sistemacontable.services.MoviDinerService;
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

    @Autowired
    MoviDinerService moviDinerService;


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

    //get
    @GetMapping ("/Empleados/{id}")
    public Optional<Empleado> empleadoPorId (@PathVariable("id") Integer id){
        return  this.empleadoService.getEmpleadoById(id);
    }

    @PatchMapping ("/Empleados/{id}")
    public Empleado actualizarEmpleado (@PathVariable ("id") Integer id, @RequestBody Empleado empleado){
        Empleado worker = empleadoService.getEmpleadoById(id).get();
        worker.setNombre(empleado.getNombre());
        worker.setCorreo(empleado.getCorreo());
        worker.setEmpresaPertenece(empleado.getEmpresaPertenece());
        worker.setRolEmpleado(empleado.getRolEmpleado());
        return empleadoService.guardarOActualizaEmpleado(worker);
    }

    //Delete empleado

    @DeleteMapping ("/Empleados/{id}")
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean answers =this.empleadoService.deleteEmpleado(id);
        if(answers){
            return "Se elimio la empleado con Id"+id;
        }
        else {
            return "No se pudo eliminar el empleado con el Id"+id;
        }
    }

    //Movimiento de dinero

        @GetMapping("/Movimientos")//Consultar todos los movimientos
        public List<MovimientoDinero> listarMovimientoDinero(){
            return this.moviDinerService.getAllMovimientoDinero();
        }

        @PostMapping ("/Empresas/{id}/Movimientos")//Guardar todos los movimientos
        public MovimientoDinero guardarOActualizarMovimiento(@PathVariable Integer id ,@RequestBody MovimientoDinero nuevoMovimientoDinero){
            return this.moviDinerService.crearMovimientoDinero(nuevoMovimientoDinero);
        }

        @GetMapping("/Movimientos/{id}") ////Consultar movimiento por id
        public MovimientoDinero buscarMoviDinerbyId(@PathVariable("id") Integer id){
            return moviDinerService.buscarMoviDinerbyId(id);

        }


    ///  @PatchMapping("/movimientos/{id}")//Editar o actualizar un movimiento
    ///  public MovimientoDinero actualizarMovimientoDinero(@PathVariable("id")Integer id, @RequestBody MovimientoDinero MovimientoDineroActualizar){
    ///     MovimientoDinero mov=MoviDinerService.guardarActualizarMovimiento(id);
    ///     mov.setConceptoMovimiento(mov.getConceptoMovimiento());
    ///    mov.setMovimientoDinero(mov.getMovimientoDinero());
    ///    mov.setEmpleadoMovimiento  (mov.getEmpleadoMovimiento());


    /// }



    @GetMapping("/Empresas/{id}/Movimientos")
    public List<MovimientoDinero> buscarMovDinerByEmpresa(@PathVariable  Integer id){
        //Empresa empresa = this.empresaServicios.getEmpresaById(id);
        return  this.moviDinerService.buscarMoviDinerbyEmpresa(id);
    }


    @PatchMapping("/Empresas/{id}/Movimientos")
    public MovimientoDinero actualizarMovimiento(@PathVariable  Integer id,@RequestBody MovimientoDinero nuevoMovimientoDinero){
        MovimientoDinero movimientoActual  = this.moviDinerService.buscarMoviDinerbyId(id);
        movimientoActual.setConceptoMovimiento(nuevoMovimientoDinero.getConceptoMovimiento());
        movimientoActual.setMovimientoDinero(nuevoMovimientoDinero.getMovimientoDinero());
        return this.moviDinerService.guardarOActualizarMovimiento(movimientoActual);
    }


}



