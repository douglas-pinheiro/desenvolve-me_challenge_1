package br.com.douglaspinheiro.clientes.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfUtilTest {

    @Test
    void DeveformatarCpf() {
        var cpf = "922.472.970-30";
        var cpfFormatado = CpfUtil.formataCpf(cpf);

        assertEquals("92247297030", cpfFormatado);
    }

    @Test
    void DeveRetornarTrueQuandoCpfValido() {
        var cpf = "922.472.970-30";
        assertTrue(CpfUtil.validaCPF(cpf));
    }

    @Test
    void DeveRetornarFalseQuandoCpfInvalido() {
        var cpf = "123.456.789-00";
        assertFalse(CpfUtil.validaCPF(cpf));
    }
}