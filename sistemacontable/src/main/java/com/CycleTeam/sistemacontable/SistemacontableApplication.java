package com.CycleTeam.sistemacontable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication


public class SistemacontableApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemacontableApplication.class, args);


		//Este print es para verificar que el programa esté corriendo de manera apropiada
		System.out.println("Prueba de programa corriendo");

	}
}