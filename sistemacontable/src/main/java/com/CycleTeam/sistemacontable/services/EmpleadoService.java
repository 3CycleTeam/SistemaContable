package com.CycleTeam.sistemacontable.services;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmpleadoService {
@Autowired
EmpleadoRepository empleadoRepository;

    public List <Empleado> listarEmpleados (){
        return (List<Empleado>) this.empleadoRepository.findAll();
    }

}
