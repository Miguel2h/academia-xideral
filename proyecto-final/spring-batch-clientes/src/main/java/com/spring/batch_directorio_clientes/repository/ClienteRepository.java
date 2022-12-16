package com.spring.batch_directorio_clientes.repository;

import com.spring.batch_directorio_clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
