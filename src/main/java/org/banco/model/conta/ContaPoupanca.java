package org.banco.model.conta;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    @Override
    public TipoConta getTipoConta() {
        return TipoConta.POUPANCA;
    }

    @Override
    public boolean sacar(BigDecimal valor) {
        // Na poupança, não há limite especial — só saca se houver saldo suficiente
        if (saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
            historico.add(new org.banco.transacao.Transacao("Saque Poupança", valor.negate()));
            return true;
        }
        return false;
    }
}