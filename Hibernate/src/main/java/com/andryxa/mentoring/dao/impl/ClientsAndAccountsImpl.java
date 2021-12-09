package com.andryxa.mentoring.dao.impl;

import com.andryxa.mentoring.dao.ClientsAndAccounts;
import com.andryxa.mentoring.entity.Account;
import com.andryxa.mentoring.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientsAndAccountsImpl implements ClientsAndAccounts {
    private final EntityManager entityManager;

    public ClientsAndAccountsImpl(final String unit) {
        this.entityManager = Persistence.createEntityManagerFactory(unit).createEntityManager();
    }

    @Override
    public List<Account> getAllAccounts() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
        Root<Account> accountRoot = criteriaQuery.from(Account.class);
        return entityManager.createQuery(criteriaQuery.select(accountRoot).orderBy(criteriaBuilder.asc(accountRoot.get("ownerId")))).getResultList();
    }

    @Override
    public List<Client> getAllClients() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> clientCriteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = clientCriteriaQuery.from(Client.class);
        return entityManager.createQuery(clientCriteriaQuery.select(clientRoot)).getResultList();
    }


}
