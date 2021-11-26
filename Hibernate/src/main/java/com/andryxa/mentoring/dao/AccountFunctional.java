package com.andryxa.mentoring.dao;


import com.andryxa.mentoring.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class AccountFunctional {
    static Scanner scanner = new Scanner(System.in);
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

    public static void addAccount() {

        try {
            transaction.begin();

            Account account = new Account();
            System.out.println("Print nickname");
            String nickname = scanner.next();
            account.setName(nickname);
            System.out.println("Print password");
            String password = scanner.next();
            account.setPassword(password);
            entityManager.persist(account);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public static void deleteAccount() {

        try {
            transaction.begin();
            System.out.println("Enter Id");
            Integer id = scanner.nextInt();
            Account account = entityManager.find(Account.class, id);
            entityManager.remove(account);
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public static void allAccounts() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> c = cq.from(Account.class);
        List<Account> qq = entityManager.createQuery(cq.select(c)).getResultList();
        for (Account account : qq) {
            int id = account.getId();
            String name = account.getName();
            String password = account.getPassword();
            System.out.println("id:" + id + " Name: " + name + " Password: " + password);

        }
    }

    public static void update() {
        try {
            transaction.begin();
            System.out.println("Enter Id of your account");
            Integer id = scanner.nextInt();
            Account account = entityManager.find(Account.class, id);
            System.out.println("If you want to update Name press 1\n" +
                    "If you want to update Password press2");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter name ");
                String name = scanner.next();
                account.setName(name);
            } else if (choice == 2) {
                System.out.println("Enter new password ");
                String password = scanner.next();
                account.setPassword(password);
            }
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
