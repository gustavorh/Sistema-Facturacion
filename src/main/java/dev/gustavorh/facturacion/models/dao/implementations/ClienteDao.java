package dev.gustavorh.facturacion.models.dao.implementations;

import dev.gustavorh.facturacion.models.dao.IClienteDao;
import dev.gustavorh.facturacion.models.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClienteDao implements IClienteDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }
}
