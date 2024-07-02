package br.com.alura.conversor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConversorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bem vindo ao Conversor de Moedas!");
	}
}
