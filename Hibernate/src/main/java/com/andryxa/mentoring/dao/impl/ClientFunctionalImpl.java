package com.andryxa.mentoring.dao.impl;

import com.andryxa.mentoring.dao.ClientFunctional;
import com.andryxa.mentoring.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class ClientFunctionalImpl implements ClientFunctional {

    private final EntityManager entityManager;

    public ClientFunctionalImpl(final String unit) {
        this.entityManager = Persistence.createEntityManagerFactory(unit).createEntityManager();
    }

    @Override
    public void addClient(String name, String lastName) {
        final EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Client client = new Client();
            client.setFirstName(name);
            client.setLastName(lastName);

            entityManager.persist(client);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteClient(int id) {
        final EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Client client = entityManager.find(Client.class, id);
            entityManager.remove(client);
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Client> allClients() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        return entityManager.createQuery(criteriaQuery.select(root)).getResultList();
    }
}