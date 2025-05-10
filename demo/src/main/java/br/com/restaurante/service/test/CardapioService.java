package br.com.restaurante.service.test;

import javax.persistence.EntityManager;
import br.com.restaurante.dao.OrdemDAO;
import br.com.restaurante.util.CargaDeDadosUtil;
import br.com.restaurante.util.JPAUtil;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.gEntityManagerRestaurante();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);

        OrdemDAO ordemDAO = new OrdemDAO(entityManager);
        System.out.println(ordemDAO.consultarTodos());

        entityManager.close();
    }
}