package com.CycleTeam.sistemacontable;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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


    }
}
