package com.CycleTeam.sistemacontable.repositories;

import com.CycleTeam.sistemacontable.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Integer> {

}
