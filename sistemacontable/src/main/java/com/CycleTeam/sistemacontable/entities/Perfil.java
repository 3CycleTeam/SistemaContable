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
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Empleado usuario;
    private Date fechaCreado;
    private Date fechaActualizado;

    public Perfil(Empleado usuario, Date fechaCreado, Date fechaActualizado) {
        this.usuario = usuario;
        this.fechaCreado = fechaCreado;
        this.fechaActualizado = fechaActualizado;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }


}