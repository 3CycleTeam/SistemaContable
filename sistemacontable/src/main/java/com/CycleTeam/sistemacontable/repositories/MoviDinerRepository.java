package com.CycleTeam.sistemacontable.repositories;

import com.CycleTeam.sistemacontable.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviDinerRepository extends JpaRepository<MovimientoDinero,Integer> {

}
