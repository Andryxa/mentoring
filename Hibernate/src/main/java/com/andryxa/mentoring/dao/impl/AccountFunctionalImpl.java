package com.andryxa.mentoring.dao.impl;

import com.andryxa.mentoring.dao.AccountFunctional;
import com.andryxa.mentoring.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountFunctionalImpl implements AccountFunctional {

    private final EntityManager entityManager;

    public AccountFunctionalImpl(final String unit) {
        entityManager = Persistence.createEntityManagerFactory(unit).createEntityManager();
    }

    @Override
    public void addAccount(final String nickname, final String password, final int ownerId) {
        final EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            final Account account = new Account();
            account.setName(nickname);
            account.setPassword(password);
            account.setOwnerId(ownerId);

            entityManager.persist(account);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteAccount(int id) {
        final EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            final Account account = entityManager.find(Account.class, id);
            entityManager.remove(account);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(int id, String name, String password) {
        final EntityTransaction transaction = entityManager.getTransaction();
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
        }
    }

    @Override
    public List<Account> allAccounts() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
        final Root<Account> root = criteriaQuery.from(Account.class);
        return entityManager.createQuery(criteriaQuery.select(root)).getResultList();
    }
}
