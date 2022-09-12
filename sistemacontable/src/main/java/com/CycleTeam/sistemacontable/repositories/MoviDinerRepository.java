package com.CycleTeam.sistemacontable.repositories;

import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviDinerRepository extends JpaRepository<MovimientoDinero,Integer> {



    public abstract List<MovimientoDinero> findMovimientodineroByempleadoMovimiento(Empleado empleado);




    @Query("select m from MovimientoDinero m where m.empresaMovimiento.id = ?1")
    public abstract List<MovimientoDinero> findMovimientodineroByempresaMovimientoId(Integer id );


}
