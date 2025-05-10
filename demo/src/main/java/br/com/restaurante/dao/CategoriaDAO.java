package br.com.restaurante.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.restaurante.entity.Cardapio;
import br.com.restaurante.entity.Categoria;

public class CategoriaDAO {
    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria prato) {
        this.entityManager.persist(prato);
    }

    public Cardapio consultarPorID(final Integer ID) {
        return this.entityManager.find(Cardapio.class, ID);
    }

    public List<Categoria> consultarTodos() {
        String sql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(sql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria prato) {
        this.entityManager.merge(prato);
    }

    public void deletar(final Categoria prato) {
        this.entityManager.remove(prato);
    }
}
