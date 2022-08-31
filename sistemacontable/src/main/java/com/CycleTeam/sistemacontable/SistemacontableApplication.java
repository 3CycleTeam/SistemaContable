package com.CycleTeam.sistemacontable;

import com.CycleTeam.sistemacontable.entities.Empresa;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})

public class SistemacontableApplication {

	@GetMapping("/hello")
	public String hello(){
		return "Hola Ciclo 3... Saldremos vivos de esto!";
	}

	@GetMapping("/test")
	public String test(){
		Empresa emp = new Empresa("SOLAR SAS", "Calle la geta", "3213213211","800212132-3");
		emp.setNombre("SOLAR LTDA");
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemacontableApplication.class, args);


		//Este print es para verificar que el programa esté corriendo de manera apropiada
		System.out.println("Prueba de programa corriendo");

	}

}