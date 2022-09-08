package com.CycleTeam.SistemaContable.Repositories;

import com.CycleTeam.sistemacontable.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaReposotory extends JpaRepository <Empresa, Integer> {

}
