package dev.gustavorh.facturacion.models.services;

import dev.gustavorh.facturacion.models.entities.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();
    void save(Cliente cliente);
    Cliente findById(Long id);
    void delete(Long id);
}
