package com.CycleTeam.sistemacontable.controllers;

import com.CycleTeam.sistemacontable.entities.Perfil;
import com.CycleTeam.sistemacontable.repositories.PerfilRepository;
import com.CycleTeam.sistemacontable.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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





}


