package br.com.douglaspinheiro.clientes.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CpfUtil {

    public static String formataCpf(String cpf) {
        return cpf.replace(".", "").replace("-", "");
    }

    public static boolean validaCPF(String cpf){
        log.info("Verificando se o CPF é válido");
        cpf = formataCpf(cpf);
        return verificaPrimeiroDigito(cpf) && verificaSegundoDigito(cpf);
    }

    private static boolean verificaPrimeiroDigito(String cpf) {
        int primeiroDigito;
        int[] multiplicador = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;

        for(int i=0; i<multiplicador.length; i=i+1) {
            soma = soma + multiplicador[i] * Character.digit(cpf.charAt(i), 10);
        }

        int resto = soma % 11;
        if(resto<2) primeiroDigito = 0;
        else primeiroDigito = 11 - resto;

        return primeiroDigito == Character.digit(cpf.charAt(9), 10);
    }

    private static boolean verificaSegundoDigito(String cpf) {
        int segundoDigito;
        int[] multiplicador = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;

        for(int i=0; i<multiplicador.length; i=i+1)
        {
            soma = soma + multiplicador[i] * Character.digit(cpf.charAt(i), 10);
        }

        int resto = soma % 11;
        if(resto<2) segundoDigito = 0;
        else segundoDigito = 11 - resto;

        return segundoDigito == Character.digit(cpf.charAt(10), 10);
    }
}
