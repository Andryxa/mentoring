package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.entity.Client;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class ClientFunctional {
    static Scanner scanner = new Scanner(System.in);
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();


    public static void addClient() {

        try {
            transaction.begin();

            Client client = new Client();
            System.out.println("Print Name");
            String name = scanner.next();
            client.setFirstName(name);
            System.out.println("Enter lastname");
            String lastname = scanner.next();
            client.setLastName(lastname);
            entityManager.persist(client);


            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();

            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void deleteClient() {

        try {
            transaction.begin();
            System.out.println("Enter Id");
            Integer id = scanner.nextInt();
            Client client = entityManager.find(Client.class, id);
            entityManager.remove(client);
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void allClients() {
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




