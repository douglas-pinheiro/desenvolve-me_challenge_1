package br.com.douglaspinheiro.clientes.controller;

import br.com.douglaspinheiro.clientes.controller.datacontract.ClienteDataContract;
import br.com.douglaspinheiro.clientes.entity.Cliente;
import br.com.douglaspinheiro.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {

    private final ClienteService clienteService;

    @PostMapping
    public Cliente createCliente (@RequestBody ClienteDataContract request){
        return clienteService.createCliente(request);
    }

    @GetMapping
    public List<Cliente> getClientes(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return clienteService.getClientes(page, pageSize);
    }

    @GetMapping("/{cpf_cliente}")
    public Cliente getClienteByCpf(@PathVariable("cpf_cliente") String cpf){
        return clienteService.getClienteByCPF(cpf);
    }
}
