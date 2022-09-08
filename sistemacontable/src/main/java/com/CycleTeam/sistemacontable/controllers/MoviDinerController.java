package com.CycleTeam.sistemacontable.controllers;


import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import com.CycleTeam.sistemacontable.services.MoviDinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviDinerController {
    @Autowired
    MoviDinerService moviDinerService;

    @GetMapping("/Movimientos")//Consultar todos los movimientos
    public List<MovimientoDinero> listarMovimientoDinero(){
        return this.moviDinerService.getAllMovimientoDinero();
    }

    @PostMapping ("/Movimiento")//Guardar todos los movimientos
    public MovimientoDinero crearMovimientoDinero(@RequestBody MovimientoDinero nuevoMovimientoDinero){
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



}
