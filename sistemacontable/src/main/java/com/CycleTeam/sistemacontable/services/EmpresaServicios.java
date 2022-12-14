package com.CycleTeam.sistemacontable.services;

import com.CycleTeam.sistemacontable.entities.Empresa;
import com.CycleTeam.sistemacontable.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpresaServicios {
    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;

    }

    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();

    }
    public boolean guardarOActualizaEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        if(empresaRepository.findById(emp.getId())!= null){
            return true;
        }
        return false;
    }

    public  void deleteEmpresa (Integer id){
        empresaRepository.deleteById(id);

    }
}
