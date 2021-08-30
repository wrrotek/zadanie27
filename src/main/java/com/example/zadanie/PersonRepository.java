package com.example.zadanie;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PersonRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("SELECT t FROM Person t", Person.class);
        return query.getResultList();
    }

    public void save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

}
