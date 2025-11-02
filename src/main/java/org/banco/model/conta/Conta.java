package org.banco.model.conta;

import org.banco.model.cliente.Cliente;
import org.banco.transacao.Transacao;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Conta {
    protected String numero;
    protected Cliente titular;
    protected BigDecimal saldo = BigDecimal.ZERO;
    protected List<Transacao> historico = new ArrayList<>();

    public abstract TipoConta getTipoConta();

    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
        historico.add(new Transacao("Depósito", valor));
    }

    public boolean sacar(BigDecimal valor) {
        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            historico.add(new Transacao("Saque", valor.negate()));
            return true;
        }
        return false;
    }
}
