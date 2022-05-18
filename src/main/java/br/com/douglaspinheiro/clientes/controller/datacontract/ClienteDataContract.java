package br.com.douglaspinheiro.clientes.controller.datacontract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClienteDataContract {

    private String nome;

    private String cpf;

    private LocalDate nascimento;
}
