package br.com.sdney.servico_notificacao;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    private String idUsuario;
    private BigDecimal valor;
    private String pais;
    private long timestamp;
}