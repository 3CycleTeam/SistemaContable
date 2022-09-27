package com.CycleTeam.sistemacontable.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  nombreRol;
    private String fechaCreado;
    private String fechaActualizado;

    public Perfil(String nombreRol, String fechaCreado, String fechaActualizado) {
        this.nombreRol = nombreRol;
        this.fechaCreado = fechaCreado;
        this.fechaActualizado = fechaActualizado;
    }
}