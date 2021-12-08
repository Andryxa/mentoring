package com.andryxa.mentoring.menu;

import com.andryxa.mentoring.dao.ClientFunctional;

import java.util.Scanner;

public class ClientMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        ClientFunctional clientFunctional = new ClientFunctional();
        System.out.println("Add client press 1\n" +
                "Delete client press 2\n" +
                "Show all clients press 3");
        int method = scanner.nextInt();

        if (method == 1) {
            System.out.println("Print Name");
            String name = scanner.next();
            System.out.println("Enter lastname");
            String lastName = scanner.next();

            clientFunctional.addClient(name, lastName);
        } else if (method == 2) {
            System.out.println("Enter Id");
            int id = scanner.nextInt();
            clientFunctional.deleteClient(id);
        } else if (method == 3) {
            clientFunctional.allClients();
        }
    }
}

