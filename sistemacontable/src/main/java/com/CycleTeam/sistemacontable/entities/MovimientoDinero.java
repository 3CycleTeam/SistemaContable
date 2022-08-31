package com.CycleTeam.sistemacontable.entities;

public class MovimientoDinero {
	//atributos
    private String montoDinero;
    private String conceptoMovimiento;
    private String empleadoMovimiento;
    private String rolEmpleado;

    // getters & setters


    public String getMontoDinero() {
        return montoDinero;
    }

    public void setMontoDinero(String montoDinero) {
        this.montoDinero = montoDinero;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }
    
    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public String getEmpleadoMovimiento() {
        return empleadoMovimiento;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }
// Constructor
    public MovimientoDinero(String montoDinero, String conceptoMovimiento, String empleadoMovimiento, String rolEmpleado) {
        this.montoDinero = montoDinero;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleadoMovimiento = empleadoMovimiento;
        this.rolEmpleado = rolEmpleado;
    }
}

//Probando IntelliJ
