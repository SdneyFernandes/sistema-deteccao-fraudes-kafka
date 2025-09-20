package br.com.sdney.processador_fraudes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.sdney.processador_fraudes.FraudeDetectorService;


@Service
public class ConsumidorFraudes {

    @Autowired
    private FraudeDetectorService fraudeDetectorService;
    @KafkaListener(topics = "transacoes", groupId = "fraudes-processor-group")
    public void processarTransacao(Transacao transacao) {
        fraudeDetectorService.verificarFraude(transacao);
    }
}