package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.Main;
import com.andryxa.mentoring.entity.Client;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientFunctional {

    public void addClient(String name, String lastName) {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
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
            entityManager.close();
        }
    }

    public void deleteClient(int id) {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Client client = entityManager.find(Client.class, id);
            entityManager.remove(client);
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public void allClients() {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> c = cq.from(Client.class);
        List<Client> qq = entityManager.createQuery(cq.select(c)).getResultList();
        for (Client client : qq) {
            int id = client.getId();
            String firstname = client.getFirstName();
            String lastname = client.getLastName();
            System.out.println("id:" + id + " firstName: " + firstname + " lastName: " + lastname);
        }

    }

}




