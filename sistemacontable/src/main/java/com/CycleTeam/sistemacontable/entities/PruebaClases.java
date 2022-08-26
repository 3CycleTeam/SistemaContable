package com.CycleTeam.sistemacontable.entities;

public class PruebaClases {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("3CycleTeam","Estamos en todos lados ", "018000","00112233");
        System.out.println(empresa.getNombre()+" "+empresa.getDireccion());

    }

}
