package br.com.douglaspinheiro.clientes.service.impl;

import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.converter.ClienteConverter;
import br.com.douglaspinheiro.clientes.entity.Cliente;
import br.com.douglaspinheiro.clientes.exception.ClienteJaExisteException;
import br.com.douglaspinheiro.clientes.exception.ClienteNotFoundException;
import br.com.douglaspinheiro.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteServiceImpl service;

    @Test
    void DeveCriarUmCliente() {

        var dataContract = ClienteDataContract.builder()
                .cpf("25798054004")
                .nascimento(LocalDate.now())
                .nome("João do Teste")
                .build();
        var entity = ClienteConverter.dataContractToEntity(dataContract);

        when(repository.save(any())).thenReturn(entity);
        when(repository.getClienteByCpf(any())).thenReturn(Optional.empty());

        var cliente = service.createCliente(dataContract);

        assertEquals(entity, cliente);
    }

    @Test
    void NaoDeveCriarUmClienteQueJaExiste() {

        var dataContract = ClienteDataContract.builder()
                .cpf("25798054004")
                .nascimento(LocalDate.now())
                .nome("João do Teste")
                .build();
        var entity = ClienteConverter.dataContractToEntity(dataContract);

        when(repository.getClienteByCpf(any())).thenReturn(Optional.of(entity));

        assertThrows(ClienteJaExisteException.class, () ->
                service.createCliente(dataContract));
    }

    @Test
    void DeveRetornarUmClienteByCPF() {
        var dataContract = ClienteDataContract.builder()
                .cpf("25798054004")
                .nascimento(LocalDate.now())
                .nome("João do Teste")
                .build();
        var entity = ClienteConverter.dataContractToEntity(dataContract);

        when(repository.getClienteByCpf(any())).thenReturn(Optional.of(entity));

        var cliente = service.getClienteByCPF(dataContract.getCpf());

        assertEquals(entity, cliente);
    }

    @Test
    void DeveRetornarErroQuandoClienteNaoExiste() {
        var cpf = "25798054004";

        when(repository.getClienteByCpf(any())).thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () ->
                service.getClienteByCPF(cpf));
    }

    @Test
    void DeveRetornarUmaListaDeClientes() {

        var cliente1 = ClienteConverter.dataContractToEntity(ClienteDataContract.builder()
                .cpf("25798054004")
                .nascimento(LocalDate.now())
                .nome("João do Teste")
                .build());

        var cliente2 = ClienteConverter.dataContractToEntity(ClienteDataContract.builder()
                .cpf("21697571042")
                .nascimento(LocalDate.now())
                .nome("Maria do Teste")
                .build());

        Page<Cliente> clientes = new PageImpl<>(Arrays.asList(cliente1, cliente2));
        when(repository.findAll(any(PageRequest.class))).thenReturn(clientes);

        assertEquals(clientes.getContent(), service.getClientes(0, 10));
    }
}