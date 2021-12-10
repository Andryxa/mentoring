package com.andryxa.mentoring;

import com.andryxa.mentoring.dao.AccountFunctional;
import com.andryxa.mentoring.dao.ClientFunctional;
import com.andryxa.mentoring.dao.ClientsAndAccounts;
import com.andryxa.mentoring.dao.impl.AccountFunctionalImpl;
import com.andryxa.mentoring.dao.impl.ClientFunctionalImpl;
import com.andryxa.mentoring.dao.impl.ClientsAndAccountsImpl;
import com.andryxa.mentoring.menu.impl.AccountMenu;
import com.andryxa.mentoring.menu.impl.ClientMenu;
import com.andryxa.mentoring.menu.impl.ClientsAndAccountsMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String unitName = "default";
        final ClientFunctional clientFunctional = new ClientFunctionalImpl(unitName);
        final ClientMenu clientMenu = new ClientMenu(scanner, clientFunctional);
        final AccountFunctional accountFunctional = new AccountFunctionalImpl(unitName);
        final AccountMenu accountMenu = new AccountMenu(scanner, accountFunctional);
        final ClientsAndAccounts clientsAndAccounts = new ClientsAndAccountsImpl(unitName);
        final ClientsAndAccountsMenu clientsAndAccountsMenu = new ClientsAndAccountsMenu(clientsAndAccounts);

        while (true) {
            System.out.println("\nIf you want to work with table 'clients' press 1\n" +
                    "If you want to work with table 'accounts' press 2\n" +
                    "If you want to see all clients and their accounts press 3\n" +
                    "If you want to close the program press 0");
            int choice = scanner.nextInt();

            if (choice == 1) {
                clientMenu.start();
            } else if (choice == 2) {
                accountMenu.start();
            } else if (choice == 3) {
                clientsAndAccountsMenu.start();
            } else if (choice == 0) {
                break;
            }
        }
    }
}

