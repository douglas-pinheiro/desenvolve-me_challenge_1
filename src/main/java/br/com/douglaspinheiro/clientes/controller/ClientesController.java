package br.com.douglaspinheiro.clientes.controller;

import br.com.douglaspinheiro.clientes.converter.ClienteConverter;
import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteDataContract createCliente (@RequestBody ClienteDataContract request){
        return ClienteConverter.entityToDataContract(clienteService.createCliente(request));
    }

    @GetMapping
    public List<ClienteDataContract> getClientes(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "100") int pageSize){
        return clienteService.getClientes(page, pageSize)
                .stream()
                .map(ClienteConverter::entityToDataContract)
                .toList();
    }

    @GetMapping("/{cpf_cliente}")
    public ClienteDataContract getClienteByCpf(@PathVariable("cpf_cliente") String cpf){
        return ClienteConverter.entityToDataContract(clienteService.getClienteByCPF(cpf));
    }
}
