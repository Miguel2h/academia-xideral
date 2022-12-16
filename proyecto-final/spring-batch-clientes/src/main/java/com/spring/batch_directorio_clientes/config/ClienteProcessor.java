package com.spring.batch_directorio_clientes.config;

import com.spring.batch_directorio_clientes.entity.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {

        return cliente;
        
    }
}
