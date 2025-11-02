package org.banco.repository;

import org.banco.model.conta.Conta;

import java.util.*;

public class ContaRepository {

    private final Map<String, Conta> contas = new HashMap<>();

    public void salvar(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public Optional<Conta> buscarPorNumero(String numero) {
        return Optional.ofNullable(contas.get(numero));
    }

    public List<Conta> listarTodas() {
        return new ArrayList<>(contas.values());
    }
}