package com.andryxa.mentoring.menu;

import java.util.Scanner;

import static com.andryxa.mentoring.dao.ClientFunctional.*;

public class ClientMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Add client press 1\n" +
                "Delete client press 2\n" +
                "Show all clients press 3");
        int method = scanner.nextInt();

        if (method == 1) {
            addClient();
        } else if (method == 2) {
            deleteClient();
        } else if (method == 3) {
            allClients();
        }
    }
}

