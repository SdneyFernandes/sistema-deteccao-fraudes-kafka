package br.com.sdney.gerador_transacoes;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;

@Service
public class GeradorTransacoes {

    @Autowired
    private KafkaTemplate<String, Transacao> kafkaTemplate;

    private final Faker faker = new Faker(new Locale("pt-BR"));

    @Scheduled(fixedRate = 2000) 
    public void gerarEEnviarTransacao() {

String precoString = faker.commerce().price(1.0, 5500.0);
        BigDecimal valorCorrigido = new BigDecimal(precoString.replace(",", "."));
       

        Transacao transacao = new Transacao(
                faker.number().digits(10),
                valorCorrigido, 
                faker.address().countryCode(),
                System.currentTimeMillis()
        );

        System.out.println("Enviando transação: " + transacao);
        kafkaTemplate.send("transacoes", transacao);
    }
}