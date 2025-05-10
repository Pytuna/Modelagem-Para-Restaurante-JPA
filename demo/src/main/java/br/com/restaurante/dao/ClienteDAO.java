package br.com.restaurante.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.restaurante.entity.Cliente;
import br.com.restaurante.entity.ClienteID;

public class ClienteDAO {
    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente consultarPorID(final ClienteID ID) {
        return this.entityManager.find(Cliente.class, ID);
    }

    public List<Cliente> consultarTodos() {
        String sql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(sql, Cliente.class).getResultList();
    }

    public List<Cliente> consultarPorNome(final String nome) {
        String sql = "SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome)";
        return this.entityManager.createQuery(sql, Cliente.class).setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public void atualizar(final Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void deletar(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }
}
