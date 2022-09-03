// Clase empleado
package com.CycleTeam.sistemacontable.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String nombre;
  @ManyToOne
  @JoinColumn(name = "empresa_pertenece_id")
  private Empresa empresaPertenece;
  private String correo;
  private String rolEmpleado;

  //Constructor 
  public Empleado(String nombre, String correo, Empresa empresaPertenece, String rolEmpleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaPertenece = empresaPertenece;
        this.rolEmpleado = rolEmpleado;
  }
}

// By: 3CycleTeam


