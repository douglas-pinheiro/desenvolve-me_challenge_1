package br.com.douglaspinheiro.clientes.controller.converter;

import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.entity.Cliente;

public class ClienteConverter {

    public static ClienteDataContract entityToDataContract (Cliente cliente){
        return ClienteDataContract.builder()
                .nascimento(cliente.getNascimento())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }

    public static Cliente dataContractToEntity (ClienteDataContract cliente){
        return Cliente.builder()
                .nascimento(cliente.getNascimento())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }
}
