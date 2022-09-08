package com.UdeA.Ciclo3.Repositorios;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaReposotory extends JpaRepository <Empresa, Integer> {

}
