package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.entity.ClientEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ClientFunctional {
    static Scanner scanner = new Scanner(System.in);
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

    public static void main(String[] args) {
        System.out.println("Add client press 1\n" +
                "Delete client press 2\n" +
                "Show all clients press 3");
        int method = scanner.nextInt();
        if (method == 1) {
            addClient();
        } else if (method == 2) {
            deleteClient();
        } else if (method == 3) {

        }
    }


    public static void addClient() {

        try {
            transaction.begin();

            ClientEntity pupkin = new ClientEntity();
            System.out.println("Print Name");
            String name = scanner.next();
            pupkin.setFirstName(name);
            System.out.println("Enter lastname");
            String lastname = scanner.next();
            pupkin.setLastName(lastname);
            entityManager.persist(pupkin);


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
            ClientEntity movie = entityManager.find(ClientEntity.class, id);
            entityManager.remove(movie);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

