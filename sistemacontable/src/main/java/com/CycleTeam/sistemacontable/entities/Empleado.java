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

  private String contrasena;

  //Constructor 
  public Empleado(String nombre, String correo, Empresa empresaPertenece, Perfil rolEmpleado, String contrasena) {///pendiente agregar en constructor contrasena
        this.nombre = nombre;
        this.correo = correo;
        this.empresaPertenece = empresaPertenece;
        this.rolEmpleado = rolEmpleado;
        this.contrasena=contrasena;
  }
}

// By: 3CycleTeam


