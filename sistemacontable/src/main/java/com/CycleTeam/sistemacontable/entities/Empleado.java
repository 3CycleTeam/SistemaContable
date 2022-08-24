package com.CycleTeam.sistemacontable.entities;

public class Empleado {
    private String nombre;
    private String correo;
    private String empresaPertenece;
    private String rolEmpleado;

    public String getNombre() {
        return nombre;
    }

    public Empleado(String nombre, String correo, String empresaPertenece, String rolEmpleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaPertenece = empresaPertenece;
        this.rolEmpleado = rolEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaPertenece() {
        return empresaPertenece;
    }

    public void setEmpresaPertenece(String empresaPertenece) {
        this.empresaPertenece = empresaPertenece;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
