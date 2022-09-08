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

    @GetMapping("/listarperfiles")///Get es para leer registros
    public List<Perfil> listarPerfiles() {
        return this.perfilService.getPerfiles();
    }

    @PostMapping("/crearperfil")// Enviar Registros
    public Perfil crearPerfil(@RequestBody Perfil nuevoPerfil) {
       return this.perfilService.crearPerfil(nuevoPerfil);
    }

    @PatchMapping("/perfiles/{id}")//Actualizar Registros
    public Perfil actulizarperfil(@RequestBody Perfil nuevoPerfil, @PathVariable Integer id){
        Perfil perfilActual= this.perfilService.buscarPerfilbyId(id);
        perfilActual.setNombreRol(nuevoPerfil.getNombreRol());
        perfilActual.setFechaActualizado(new Date());
        return  this.perfilService.actualizarPerfil(perfilActual);

    }

    @DeleteMapping("/perfiles/{id}")///Borrar Registros
    public String  actulizarperfil(@PathVariable Integer id){
        try {
            this.perfilService.eliminarPerfilId(id);
            return "Borrado  ok";
        } catch (Exception e) {
            return "No se pudo borrar el Registro "+id+" El Error es: "+e.getMessage();
        }
    }





}


