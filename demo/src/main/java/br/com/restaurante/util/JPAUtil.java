package br.com.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory RESTAURANTE = Persistence.createEntityManagerFactory("restaurante");
    public static EntityManager gEntityManagerRestaurante() {
        return RESTAURANTE.createEntityManager();
    }
}
