package com.CycleTeam.sistemacontable.entities;

public class MovimientoDinero {
    private String montoDinero;
    private String conceptoMovimiento;
    private String empleadoMovimiento;
    private String rolEmpleado;

    public String getMontoDinero() {
        return montoDinero;
    }

    public void setMontoDinero(String montoDinero) {
        this.montoDinero = montoDinero;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
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

    public MovimientoDinero(String montoDinero, String conceptoMovimiento, String empleadoMovimiento, String rolEmpleado) {
        this.montoDinero = montoDinero;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleadoMovimiento = empleadoMovimiento;
        this.rolEmpleado = rolEmpleado;
    }
}
