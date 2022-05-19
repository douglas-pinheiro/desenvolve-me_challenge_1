package br.com.douglaspinheiro.clientes.repository;

import br.com.douglaspinheiro.clientes.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> getClienteByCpf(String cpf);

    Page<Cliente> findAll(Pageable pageable);
}
