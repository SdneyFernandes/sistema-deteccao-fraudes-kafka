package br.com.sdney.servico_notificacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumidorAlertas {

    @KafkaListener(topics = "fraudes-detectadas", groupId = "notificacao-group")
    public void receberAlertaDeFraude(Transacao transacaoFraudulenta) {
        System.out.println("=========================================");
        System.out.println("!!! ALERTA DE FRAUDE DETECTADA !!!");
        System.out.println("Enviando notificação para o usuário: " + transacaoFraudulenta.getIdUsuario());
        System.out.println("Detalhes da Transação: " + transacaoFraudulenta);
        System.out.println("=========================================");
    }
}