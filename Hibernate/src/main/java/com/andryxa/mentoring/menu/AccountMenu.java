package com.andryxa.mentoring.menu;

import java.util.Scanner;

import com.andryxa.mentoring.dao.AccountFunctional;

public class AccountMenu {

    public static void start() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Add account press 1\n" +
                "Delete account press 2\n" +
                "Update account press 3\n" +
                "Show all accounts press 4");
        int method = scanner.nextInt();

        AccountFunctional accountFunctional = new AccountFunctional();

        if (method == 1) {

            System.out.println("Print nickname");
            String nickname = scanner.next();
            System.out.println("Print password");
            String password = scanner.next();
            System.out.println("Print ownerId");
            int ownerId = scanner.nextInt();
            accountFunctional.addAccount(nickname, password, ownerId);
        } else if (method == 2) {

            System.out.println("Enter Id");
            int id = scanner.nextInt();
            accountFunctional.deleteAccount(id);
        } else if (method == 3) {

            System.out.println("Enter Id of your account");
            int id = scanner.nextInt();
            System.out.println("Enter name ");
            String name = scanner.next();
            System.out.println("Enter new password ");
            String password = scanner.next();
            accountFunctional.update(id, name, password);

        } else if (method == 4) {
            accountFunctional.allAccounts();
        }
    }
}

