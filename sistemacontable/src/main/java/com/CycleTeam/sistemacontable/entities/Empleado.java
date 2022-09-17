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
  @ManyToOne
  @JoinColumn(name = "rol_empleado_id")
  private Perfil rolEmpleado;

  //Constructor 
  public Empleado(String nombre, String correo, Empresa empresaPertenece, Perfil rolEmpleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaPertenece = empresaPertenece;
        this.rolEmpleado = rolEmpleado;
  }
}

// By: 3CycleTeam


