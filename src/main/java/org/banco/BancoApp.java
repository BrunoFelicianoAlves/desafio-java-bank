package org.banco;

import org.banco.model.cliente.Cliente;
import org.banco.model.conta.Conta;
import org.banco.model.conta.ContaCorrente;
import org.banco.model.conta.ContaPoupanca;
import org.banco.repository.ContaRepository;
import org.banco.service.PixService;

import java.math.BigDecimal;

public class BancoApp {
    public static void main(String[] args) {
        ContaRepository contaRepo = new ContaRepository();
        PixService pix = new PixService();

        Cliente bruno = new Cliente("Bruno", "12345678900", "bruno@email");
        Cliente maria = new Cliente("Maria", "12345678910", "maria@email");

        Conta cc = new ContaCorrente();
        cc.setNumero("001");
        cc.setTitular(bruno);
        contaRepo.salvar(cc);

        Conta cp = new ContaPoupanca();
        cp.setNumero("002");
        cp.setTitular(maria);
        contaRepo.salvar(cp);

        cc.depositar(BigDecimal.valueOf(1000));
        pix.transferir(cc, cp, BigDecimal.valueOf(200));

        System.out.println("Saldo Bruno: " + cc.getSaldo());
        System.out.println("Saldo Maria: " + cp.getSaldo());
    }
}