package com.andryxa.mentoring.menu;

import java.util.Scanner;

import static com.andryxa.mentoring.dao.AccountFunctional.*;

public class AccountMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Add account press 1\n" +
                "Delete account press 2\n" +
                "Update account\n" +
                "Show all accounts press 3");
        int method = scanner.nextInt();
        if (method == 1) {
            addAccount();
        } else if (method == 2) {
            deleteAccount();
        } else if (method == 3) {
            update();
        } else if (method == 4) {
            allAccounts();
        }
    }
}
