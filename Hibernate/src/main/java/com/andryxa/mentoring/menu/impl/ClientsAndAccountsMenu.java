package com.andryxa.mentoring.menu.impl;

import com.andryxa.mentoring.dao.ClientsAndAccounts;
import com.andryxa.mentoring.entity.Account;
import com.andryxa.mentoring.entity.Client;

import java.util.List;

public class ClientsAndAccountsMenu {
    private final ClientsAndAccounts clientsAndAccounts;

    public ClientsAndAccountsMenu(ClientsAndAccounts clientsAndAccounts) {
        this.clientsAndAccounts = clientsAndAccounts;
    }

    public void start() {
        printAllClientsAndAccounts();
    }


    private void printAllClientsAndAccounts() {
        final List<Client> clients = clientsAndAccounts.getAllClients();
        final List<Account> accounts = clientsAndAccounts.getAllAccounts();
        for (Client client : clients) {
            int id = client.getId();
            String firstName = client.getFirstName();
            String lastName = client.getLastName();
            System.out.println("id:" + id + " First Name: " + firstName + " Last Name: " + lastName);
            for (Account account : accounts) {
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
