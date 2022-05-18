package br.com.douglaspinheiro.clientes.service;

import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente createCliente (ClienteDataContract cliente);

    Cliente getClienteByCPF (String cpf);

    List <Cliente> getClientes (int page, int pageSize);

}
