package dao;

import domain.Acessorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcessorioDAO implements IAcessorioDAO{

    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PostgreSQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }
}
