package br.com.douglaspinheiro.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClienteNotFoundException extends ResponseStatusException {

    public ClienteNotFoundException(){
        super(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }
}