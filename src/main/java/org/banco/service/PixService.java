package org.banco.service;

import org.banco.model.conta.Conta;
import org.banco.transacao.Transacao;

import java.math.BigDecimal;

public class PixService {

    public boolean transferir(Conta origem, Conta destino, BigDecimal valor) {
        if (origem.sacar(valor)) {
            destino.depositar(valor);
            origem.getHistorico().add(new Transacao("PIX para " + destino.getNumero(), valor.negate()));
            destino.getHistorico().add(new Transacao("PIX de " + origem.getNumero(), valor));
            return true;
        }
        return false;
    }
}