package br.com.douglaspinheiro.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CpfInvalidoException extends ResponseStatusException {

    public CpfInvalidoException(){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Número do CPF inválido");
    }
}