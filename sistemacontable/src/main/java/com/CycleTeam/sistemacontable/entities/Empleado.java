// Clase empleado
package com.CycleTeam.sistemacontable.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;


@Getter
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

  private String rol_empleado;



  private String contrasena;

  //Constructor


    public Empleado() {

    }

    public String getRol_empleado() {

        return rol_empleado;
    }

    public void setRol_empleado() {

        if (this.rolEmpleado.getNombreRol().equals("Administrador")) {
            this.rol_empleado = "ROLE_ADMIN";

        }
        if (this.rolEmpleado.getNombreRol().equals("Operativo")) {
            this.rol_empleado = "ROLE_USER";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getEmpresaPertenece() {
        return empresaPertenece;
    }

    public void setEmpresaPertenece(Empresa empresaPertenece) {
        this.empresaPertenece = empresaPertenece;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Perfil getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Perfil rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
        setRol_empleado();
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empleado(String nombre, Empresa empresaPertenece, String correo, Perfil rolEmpleado, String contrasena) {
        this.nombre = nombre;
        this.empresaPertenece = empresaPertenece;
        this.correo = correo;
        this.rolEmpleado = rolEmpleado;
        this.contrasena = contrasena;

        if (this.rolEmpleado.getNombreRol().equals("Administrador")) {
            this.rol_empleado = "ROLE_ADMIN";

        }
        if (this.rolEmpleado.getNombreRol().equals("Operativo")) {
            this.rol_empleado = "ROLE_USER";
        }

    }
}

// By: 3CycleTeam


