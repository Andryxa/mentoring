package com.andryxa.mentoring;

import com.andryxa.mentoring.dao.AccountFunctional;
import com.andryxa.mentoring.dao.ClientFunctional;
import com.andryxa.mentoring.dao.ClientsAndAccounts;
import com.andryxa.mentoring.dao.impl.AccountFunctionalImpl;
import com.andryxa.mentoring.dao.impl.ClientFunctionalImpl;
import com.andryxa.mentoring.dao.impl.ClientsAndAccountsImpl;
import com.andryxa.mentoring.menu.impl.AccountMenu;
import com.andryxa.mentoring.menu.impl.ClientMenuImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            final String unitName = "default";

            System.out.println("If you want to work with table 'clients' press 1\n" +
                    "If you want to work with table 'accounts' press 2\n" +
                    "If you want to see all clients and their accounts press 3\n" +
                    "If you want to close the program press 0");
            int choice = scanner.nextInt();

            if (choice == 1) {
                final ClientFunctional clientFunctional = new ClientFunctionalImpl(unitName);
                final ClientMenuImpl clientMenu = new ClientMenuImpl(scanner, clientFunctional);
                clientMenu.start();
            } else if (choice == 2) {
                final AccountFunctional accountFunctional = new AccountFunctionalImpl(unitName);
                final AccountMenu accountMenu = new AccountMenu(scanner, accountFunctional);
                accountMenu.start();
            } else if (choice == 3) {
                final ClientsAndAccounts clientsAndAccounts = new ClientsAndAccountsImpl(unitName);
                clientsAndAccounts.printAll();
            } else if (choice == 0) {
                break;
            }
        }
    }
}

