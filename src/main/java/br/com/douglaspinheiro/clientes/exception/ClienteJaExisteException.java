package br.com.douglaspinheiro.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClienteJaExisteException extends ResponseStatusException {

    public ClienteJaExisteException(){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Cliente com esse CPF já existe");
    }
}