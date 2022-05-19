package br.com.douglaspinheiro.clientes.service.impl;

import br.com.douglaspinheiro.clientes.converter.ClienteConverter;
import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.entity.Cliente;
import br.com.douglaspinheiro.clientes.exception.ClienteJaExisteException;
import br.com.douglaspinheiro.clientes.exception.ClienteNotFoundException;
import br.com.douglaspinheiro.clientes.exception.CpfInvalidoException;
import br.com.douglaspinheiro.clientes.repository.ClienteRepository;
import br.com.douglaspinheiro.clientes.service.ClienteService;
import br.com.douglaspinheiro.clientes.util.CpfUtil;
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
    public Cliente createCliente(ClienteDataContract request) {
        request.setCpf(CpfUtil.formataCpf(request.getCpf()));
        if(!CpfUtil.validaCPF(request.getCpf())){
            throw new CpfInvalidoException();
        }
        var cliente = clienteRepository.getClienteByCpf(request.getCpf());
        if (cliente.isEmpty()){
            log.info("Criando o cliente {}", request.getNome());
            return clienteRepository.save(ClienteConverter.dataContractToEntity(request));
        } else {
            log.info("Cliente com esse CPF já existe");
            throw new ClienteJaExisteException();
        }
    }

    @Override
    public Cliente getClienteByCPF(String cpf) {
        log.info("Buscando o cliente pelo CPF");
        cpf = CpfUtil.formataCpf(cpf);
        return clienteRepository.getClienteByCpf(cpf)
                .orElseThrow(() -> {
                    log.error("Cliente não encontrado");
                    return new ClienteNotFoundException();
                });
    }

    @Override
    public List<Cliente> getClientes(int page, int pageSize) {
        log.info("Buscando todos os clientes");
        PageRequest paginacao = PageRequest.of(page, pageSize);
        return clienteRepository.findAll(paginacao).getContent();
    }
}
