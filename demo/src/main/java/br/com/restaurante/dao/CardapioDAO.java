package br.com.restaurante.dao;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.restaurante.entity.Cardapio;

public class CardapioDAO {
    private EntityManager entityManager;

    public CardapioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio prato) {
        this.entityManager.persist(prato);
    }

    public Cardapio consultarPorID(final Integer ID) {
        return this.entityManager.find(Cardapio.class, ID);
    }

    public Cardapio consultaPorNome(final String filtro) {
        try {
            String sql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(sql, Cardapio.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cardapio> consultarPorValor(final Double filtro) {
        try {
            String sql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(sql, Cardapio.class).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarTodos() {
        try {
            String sql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void atualizar(final Cardapio prato) {
        this.entityManager.merge(prato);
    }

    public void deletar(final Cardapio prato) {
        this.entityManager.remove(prato);
    }
}
