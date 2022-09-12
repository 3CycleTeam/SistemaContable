package com.CycleTeam.sistemacontable.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "movimientosdedinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private Float movimientoDinero;
    private String conceptoMovimiento;
    @ManyToOne
    @JoinColumn(name = "empleado_movimiento_id")
    private Empleado empleadoMovimiento;

    @ManyToOne
    @JoinColumn(name = "empresa_movimiento_id")
    private Empresa empresaMovimiento;
    public MovimientoDinero(Float movimientoDinero, String conceptoMovimiento, Empleado empleadoMovimiento) {
        this.movimientoDinero = movimientoDinero;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleadoMovimiento = empleadoMovimiento;
    }
}