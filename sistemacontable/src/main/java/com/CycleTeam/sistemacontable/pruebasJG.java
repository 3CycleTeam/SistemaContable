package com.CycleTeam.sistemacontable;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class pruebasJG {
    public static void main(String[] args) {


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwd = "123456";
        String hashedPass1 = bCryptPasswordEncoder.encode(passwd);
        System.out.println(hashedPass1);

        boolean validar = bCryptPasswordEncoder.matches("654321", hashedPass1);
        System.out.println(validar);


    }
}
