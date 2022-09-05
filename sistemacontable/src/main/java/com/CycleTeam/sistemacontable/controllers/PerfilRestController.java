package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Perfil;
import com.CycleTeam.sistemacontable.repositories.PerfilRepository;
import com.CycleTeam.sistemacontable.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PerfilRestController {
    @Autowired
    PerfilService perfilService;

    @GetMapping("/listarperfiles")
    public List<Perfil> listarPerfiles() {
        return this.perfilService.getPerfiles();
    }

    @PostMapping("/crearperfil")
    public Perfil crearPerfil(@RequestBody Perfil nuevoPerfil) {
       return this.perfilService.crearPerfil(nuevoPerfil);
    }

    @PatchMapping("/perfiles/{id}")
    public Perfil actulizarperfil(@RequestBody Perfil nuevoPerfil, @PathVariable Integer id){
        Perfil perfilActual= this.perfilService.buscarPerfilbyId(id);
        perfilActual.setNombreRol(nuevoPerfil.getNombreRol());
        perfilActual.setFechaActualizado(new Date());
        return  this.perfilService.actualizarPerfil(perfilActual);

    }

    @DeleteMapping("/perfiles/{id}")
    public void  actulizarperfil(@PathVariable Integer id){
        this.perfilService.eliminarPerfilId(id);


    }





}


