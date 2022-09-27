package com.CycleTeam.sistemacontable;


import com.CycleTeam.sistemacontable.entities.Empleado;
import com.CycleTeam.sistemacontable.entities.Perfil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.Date;

public class pruebasJG {
    public static void main(String[] args) {


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwd = "123456";
        String hashedPass1 = bCryptPasswordEncoder.encode(passwd);
        System.out.println(hashedPass1);

        boolean validar = bCryptPasswordEncoder.matches("654321", hashedPass1);
        System.out.println(validar);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        System.out.println(timestamp);
        Perfil perfil= new Perfil("Administrador","HOY","MAÑANA");
        Empleado empleado= new Empleado();
        empleado.setRolEmpleado(perfil);
        System.out.println(empleado.getRol_empleado());


    }
}
