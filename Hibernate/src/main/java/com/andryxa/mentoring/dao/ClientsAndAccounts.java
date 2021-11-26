package com.andryxa.mentoring.dao;

import com.andryxa.mentoring.entity.Account;
import com.andryxa.mentoring.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientsAndAccounts {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void start() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
        Root<Account> accountRoot = criteriaQuery.from(Account.class);
        List<Account> accountList = entityManager.createQuery(criteriaQuery.select(accountRoot).orderBy(criteriaBuilder.asc(accountRoot.get("ownerId")))).getResultList();
        CriteriaQuery<Client> clientCriteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = clientCriteriaQuery.from(Client.class);
        List<Client> qw = entityManager.createQuery(clientCriteriaQuery.select(clientRoot)).getResultList();
        for (Client client : qw) {
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

    }
}