package com.CycleTeam.sistemacontable.services;


import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import com.CycleTeam.sistemacontable.repositories.MoviDinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MoviDinerService {
    @Autowired
    MoviDinerRepository moviDinerRepository;

    public MoviDinerService (MoviDinerRepository moviDinerRepository ){
        this.moviDinerRepository = moviDinerRepository;
    }

    public MovimientoDinero crearMovimientoDinero(MovimientoDinero nuevoMovimientoDinero){
        return this.moviDinerRepository.save(nuevoMovimientoDinero);
    }


    //listar todos los movimientos realizados|

    public List<MovimientoDinero> getAllMovimientoDinero(){
        List<MovimientoDinero> movimientoDineroList =new ArrayList<>();
        moviDinerRepository.findAll().forEach(movimientoDinero -> movimientoDineroList.add(movimientoDinero));
        return this.moviDinerRepository.findAll();
    }

    //Buscar los movimientos por id
    public MovimientoDinero buscarMoviDinerbyId(Integer id){
        return this.moviDinerRepository.findById(id).get();
    }
    //Guardar o actualizar elementos
    public MovimientoDinero guardarActualizarMovimiento (MovimientoDinero movimientoDinero) {
        MovimientoDinero mov=moviDinerRepository.save(movimientoDinero);
        return mov;
    }

    public void eliminarMoviDinerbyId (Integer id){
        this.moviDinerRepository.deleteById(id);
    }

    // public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id)
    //  {
    //     return moviDinerRepository.findByEmpleado(id);
    // }

   // public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
    //      return moviDinerRepository.findByEmpresa(id);
    //    }
    public List<MovimientoDinero> buscarMoviDinerbyEmpresa(Integer id){

        return this.moviDinerRepository.findMovimientodineroByempresaMovimientoId(id);
    }

    public List<MovimientoDinero> buscarporempleado(Empleado empleado){
        return this.moviDinerRepository.findMovimientodineroByempleadoMovimiento(empleado);

    }

    public MovimientoDinero guardarOActualizarMovimiento(MovimientoDinero movimientoDinero){
        return this.moviDinerRepository.save(movimientoDinero);
    }

    public Boolean deleteMovimiento (Integer id){
        moviDinerRepository.deleteById(id);
        if (this.moviDinerRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }
}
