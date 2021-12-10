package com.andryxa.mentoring.menu.impl;

import com.andryxa.mentoring.dao.ClientFunctional;
import com.andryxa.mentoring.entity.Client;

import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    private final ClientFunctional clientFunctional;
    private final Scanner scanner;

    public ClientMenu(Scanner scanner, ClientFunctional clientFunctional) {
        this.clientFunctional = clientFunctional;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Add client press 1\n" +
                "Delete client press 2\n" +
                "Show all clients press 3");
        int method = scanner.nextInt();
        if (method == 1) {
            addClient();
        } else if (method == 2) {
            deleteClient();
        } else if (method == 3) {
            printAllClients();
        }
    }

    private void deleteClient() {
        System.out.println("Enter Id");
        int id = scanner.nextInt();
        clientFunctional.deleteClient(id);
    }

    private void addClient() {
        System.out.println("Print Name");
        String name = scanner.next();
        System.out.println("Enter lastname");
        String lastName = scanner.next();
        clientFunctional.addClient(name, lastName);
    }

    private void printAllClients() {
        final List<Client> clients = clientFunctional.allClients();
        for (Client client : clients) {
            int id = client.getId();
            String firstname = client.getFirstName();
            String lastname = client.getLastName();
            System.out.println("id:" + id + " firstName: " + firstname + " lastName: " + lastname);
        }
    }

}

