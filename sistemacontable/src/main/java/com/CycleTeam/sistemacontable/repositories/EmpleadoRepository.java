package com.CycleTeam.sistemacontable.repositories;


import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository <Empleado, Integer> {
   // @Query (value = "Select * from empleado where empresa_id = ?1", nativeQuery = true)



    @Query("select e from Empleado e where e.empresaPertenece = ?1")
    public abstract List<Empleado> findEmpleadoByempresaPertenece(Empresa empresa);
}

