package com.CycleTeam.sistemacontable.repositories;


import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmpleadoRepository extends CrudRepository <Empleado, Integer> {
    @Query (value = "Select * from empleado where empresa_id = ?1", nativeQuery = true)
    public abstract ArrayList<Empleado> findByEmpresa (Integer id);
}

