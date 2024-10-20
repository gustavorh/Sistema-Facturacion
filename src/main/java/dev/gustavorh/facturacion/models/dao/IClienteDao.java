package dev.gustavorh.facturacion.models.dao;

import dev.gustavorh.facturacion.models.entities.Cliente;

import java.util.List;

public interface IClienteDao {
    List<Cliente> findAll();
}
