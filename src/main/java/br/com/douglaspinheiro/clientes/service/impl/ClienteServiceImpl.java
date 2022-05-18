package br.com.douglaspinheiro.clientes.service.impl;

import br.com.douglaspinheiro.clientes.controller.converter.ClienteConverter;
import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.entity.Cliente;
import br.com.douglaspinheiro.clientes.repository.ClienteRepository;
import br.com.douglaspinheiro.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(ClienteDataContract cliente) {
        return clienteRepository.save(ClienteConverter.dataContractToEntity(cliente));
    }

    @Override
    public Cliente getClienteByCPF(String cpf) {
        return clienteRepository.getClienteByCpf(cpf);
    }

    @Override
    public List<Cliente> getClientes(int page, int pageSize) {
        PageRequest paginacao = PageRequest.of(page, pageSize);
        return clienteRepository.findAll(paginacao).getContent();
    }
}
