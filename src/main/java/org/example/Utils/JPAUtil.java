package org.example.Utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    // Atributo FACTORY, constante, pertencente a esta classe.
    // Só vai criar a EntityManagerFactory apenas uma vez.
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("cadastroalunos");

    public static EntityManager getEntityManager() {
            return FACTORY.createEntityManager();
        }

}

