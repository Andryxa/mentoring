package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.Main;
import com.andryxa.mentoring.entity.Account;
import com.andryxa.mentoring.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientsAndAccounts {


    public static void start() {
        EntityManager entityManager = Main.entityManagerFactory.createEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
            Root<Account> accountRoot = criteriaQuery.from(Account.class);
            List<Account> accountList = entityManager.createQuery(criteriaQuery.select(accountRoot).orderBy(criteriaBuilder.asc(accountRoot.get("ownerId")))).getResultList();
            CriteriaQuery<Client> clientCriteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root<Client> clientRoot = clientCriteriaQuery.from(Client.class);
            List<Client> clientList = entityManager.createQuery(clientCriteriaQuery.select(clientRoot)).getResultList();
            for (Client client : clientList) {
                int id = client.getId();
                String firstName = client.getFirstName();
                String lastName = client.getLastName();
                System.out.println("id:" + id + " First Name: " + firstName + " Last Name: " + lastName);
                for (Account account : accountList) {
                    int ownerId = account.getOwnerId();
                    if (id == ownerId) {
                        int accountId = account.getId();
                        String name = account.getName();
                        String password = account.getPassword();
                        System.out.println("Account id:" + accountId + " Name: " + name + " Password: " + password);
                    }
                }
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}