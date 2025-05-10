package br.com.restaurante.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.restaurante.entity.Ordem;
import br.com.restaurante.vo.ItensPrincipaisVO;

public class OrdemDAO {
    private EntityManager entityManager;

    public OrdemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultarPorID(final Integer ID) {
        return this.entityManager.find(Ordem.class, ID);
    }

    public List<Ordem> consultarTodos() {
        String sql = "SELECT o FROM Ordem o";
        return this.entityManager.createQuery(sql, Ordem.class).getResultList();
    }

    public List<ItensPrincipaisVO> consultarItensMaisVendidos() {
        String sql = "SELECT new br.com.restaurante.vo.ItensPrincipaisVO(" +
        "c.nome, SUM(oc.quantidade)) FROM Ordem o " +
            "JOIN OrdensCardapio oc ON o.id = oc.cardapio.id " +
            "JOIN oc.cardapio c " +
            "GROUP BY c.nome " +
            "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(sql, ItensPrincipaisVO.class).getResultList();
    }

    public Ordem joinFetchCliente(final Integer id) {
        String sql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id";
        return this.entityManager.createQuery(sql, Ordem.class).setParameter("id", id).getSingleResult();
    }

    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void deletar(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
