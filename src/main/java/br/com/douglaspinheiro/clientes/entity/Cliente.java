package br.com.douglaspinheiro.clientes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate nascimento;
}
