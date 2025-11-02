package org.banco.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transacao(String descricao, BigDecimal valor, LocalDateTime data) {
    public Transacao(String descricao, BigDecimal valor) {
        this(descricao, valor, LocalDateTime.now());
    }
}