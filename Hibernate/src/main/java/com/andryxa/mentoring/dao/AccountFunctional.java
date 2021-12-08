package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.Main;
import com.andryxa.mentoring.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountFunctional implements AccountFunctionalInterface {

    public void addAccount(String nickname, String password, int ownerId) {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Account account = new Account();
            account.setName(nickname);
            account.setPassword(password);
            account.setOwnerId(ownerId);

            entityManager.persist(account);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public void deleteAccount(int id) {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Account account = entityManager.find(Account.class, id);
            entityManager.remove(account);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public void update(int id, String name, String password) {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Account account = entityManager.find(Account.class, id);
            account.setName(name);
            account.setPassword(password);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public void allAccounts() {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
        Root<Account> root = criteriaQuery.from(Account.class);
        List<Account> accounts = entityManager.createQuery(criteriaQuery.select(root)).getResultList();
        for (Account account : accounts) {
            int id = account.getId();
            String name = account.getName();
            String password = account.getPassword();
            System.out.println("id:" + id + " Name: " + name + " Password: " + password);
        }
        entityManager.close();
    }

}
