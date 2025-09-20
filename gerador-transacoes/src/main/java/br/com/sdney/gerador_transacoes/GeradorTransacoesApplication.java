package br.com.sdney.gerador_transacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GeradorTransacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorTransacoesApplication.class, args);
	}

}
