package dev.gustavorh.facturacion.models.dao;

import dev.gustavorh.facturacion.models.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
}
