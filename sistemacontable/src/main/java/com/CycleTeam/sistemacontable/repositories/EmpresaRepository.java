package com.CycleTeam.sistemacontable.repositories;

import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Integer> {


}
