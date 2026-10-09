package com.examen.mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.examen.mascotas")
@EnableJpaRepositories(basePackages = "com.examen.mascotas.repository")
public class MascotasApplication {
	public static void main(String[] args) {
		SpringApplication.run(MascotasApplication.class, args);
	}
}