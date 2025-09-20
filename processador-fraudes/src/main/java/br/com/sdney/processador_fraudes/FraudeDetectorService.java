package br.com.sdney.processador_fraudes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class FraudeDetectorService {

    @Autowired
    private KafkaTemplate<String, Transacao> kafkaTemplate;

    public void verificarFraude(Transacao transacao) {
        System.out.println("Processando transação para verificação: " + transacao.getIdUsuario());
        if (transacao.getValor().compareTo(new BigDecimal("5000")) > 0) {
            System.out.println("!!! FRAUDE DETECTADA !!! Valor alto: " + transacao.getValor() + ". Enviando para o tópico de alertas.");
            kafkaTemplate.send("fraudes-detectadas", transacao);
        }
    }
}