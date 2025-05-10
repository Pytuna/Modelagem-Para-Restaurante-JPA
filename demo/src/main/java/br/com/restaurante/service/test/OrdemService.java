package br.com.restaurante.service.test;

import javax.persistence.EntityManager;
import br.com.restaurante.dao.OrdemDAO;
import br.com.restaurante.util.CargaDeDadosUtil;
import br.com.restaurante.util.JPAUtil;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.gEntityManagerRestaurante();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdemClientes(entityManager);

        OrdemDAO ordemDao = new OrdemDAO(entityManager);
        System.out.println(ordemDao.consultarItensMaisVendidos());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
