package org.banco.model.cliente;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String nome;
    private String cpf;
    private String email;

}