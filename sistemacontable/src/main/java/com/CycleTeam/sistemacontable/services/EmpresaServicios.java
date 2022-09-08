package com.CycleTeam.sistemacontable.Servicios;

import com.CycleTeam.sistemacontable.Repositories.EmpresaReposotory;
import com.CycleTeam.sistemacontable.Entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServicios {
    @Autowired
    EmpresaReposotory empresaReposotory;

    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaReposotory.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;

    }

    public Empresa getEmpresaById(Integer id){
        return empresaReposotory.findById(id).get();

    }
    public boolean guardarOActualizaEmpresa(Empresa empresa){
        Empresa emp = empresaReposotory.save(empresa);
        if(empresaReposotory.findById(emp.getId())!= null){
            return true;
        }
        return false;
    }

}
