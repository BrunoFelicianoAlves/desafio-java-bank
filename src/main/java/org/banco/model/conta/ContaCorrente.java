package org.banco.model.conta;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    @Override
    public TipoConta getTipoConta() {
        return TipoConta.CORRENTE;
    }

    @Override
    public boolean sacar(BigDecimal valor) {
        BigDecimal limite = BigDecimal.valueOf(500);
        if (saldo.add(limite).compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            historico.add(new org.banco.transacao.Transacao("Saque CC", valor.negate()));
            return true;
        }
        return false;
    }
}