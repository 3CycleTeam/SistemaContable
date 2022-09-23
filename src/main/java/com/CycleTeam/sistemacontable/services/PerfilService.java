package com.CycleTeam.sistemacontable.services;

import com.CycleTeam.sistemacontable.entities.Perfil;
import com.CycleTeam.sistemacontable.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PerfilService {
    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> getPerfiles(){
        return this.perfilRepository.findAll();
    }

    public Perfil crearPerfil(Perfil nuevoPerfil){
       return  this.perfilRepository.save(nuevoPerfil);
    }

    public PerfilService(PerfilRepository perfilRepository) {///Constructor
        this.perfilRepository = perfilRepository;
    }

    public Perfil buscarPerfilbyId(Integer id){
        return  this.perfilRepository.findById(id).get();
    }

    public Perfil  actualizarPerfil(Perfil perfilNuevo ){
        return this.perfilRepository.save(perfilNuevo);
    }

    public void eliminarPerfilId(Integer id ){
        this.perfilRepository.deleteById(id);

    }
}
