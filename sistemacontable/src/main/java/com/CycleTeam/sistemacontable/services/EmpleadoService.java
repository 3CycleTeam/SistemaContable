package com.CycleTeam.sistemacontable.services;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoService {
@Autowired
EmpleadoRepository empleadoRepository;

    public List <Empleado> listarEmpleados (){
        return (List<Empleado>) this.empleadoRepository.findAll();
    }

    public Empleado guardarOActualizaEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    //Busqueda de empleado por Id
    public Optional<Empleado> getEmpleadoById (Integer id){
        return  empleadoRepository.findById(id);
    }

    //Eliminar empleado
    public Boolean deleteEmpleado (Integer id){
       empleadoRepository.deleteById(id);
       if (this.empleadoRepository.findById(id).isPresent()){
           return false;
       }
       return true;
    }

    public List<Empleado> empleadosByEmpresa(Empresa empresa){

        return this.empleadoRepository.findEmpleadoByempresaPertenece(empresa);
    }

    }




