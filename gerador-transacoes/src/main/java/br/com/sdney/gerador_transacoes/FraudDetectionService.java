package br.com.sdney.gerador_transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudDetectionService {

    
    @Autowired
    private KafkaTemplate<String, Transacao> kafkaTemplate;

    public void verificarFraude(Transacao transacao) {
        System.out.println("Processando transação: " + transacao.getIdUsuario());

        if (transacao.getValor().compareTo(new BigDecimal("5000")) > 0) {
            System.out.println("!!! FRAUDE DETECTADA !!! Valor alto: " + transacao.getValor());
            kafkaTemplate.send("fraudes-detectadas", transacao);
        }
    }
}