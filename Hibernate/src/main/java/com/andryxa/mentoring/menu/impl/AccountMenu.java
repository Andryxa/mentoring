package com.andryxa.mentoring.menu.impl;

import com.andryxa.mentoring.dao.AccountFunctional;
import com.andryxa.mentoring.entity.Account;

import java.util.List;
import java.util.Scanner;

public class AccountMenu {
    private final AccountFunctional accountFunctional;
    private final Scanner scanner;

    public AccountMenu(final Scanner scanner, final AccountFunctional accountFunctional) {
        this.accountFunctional = accountFunctional;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Add account press 1\n" +
                "Delete account press 2\n" +
                "Update account press 3\n" +
                "Show all accounts press 4");
        int method = scanner.nextInt();
        if (method == 1) {
            addAccount();
        } else if (method == 2) {
            deleteAccount();
        } else if (method == 3) {
            updateAccount();
        } else if (method == 4) {
            printAllAccounts();
        }
    }

    public void printAllAccounts() {
        final List<Account> accounts = accountFunctional.allAccounts();
        for (final Account account : accounts) {
            int id = account.getId();
            final String name = account.getName();
            final String password = account.getPassword();
            System.out.println("id:" + id + " Name: " + name + " Password: " + password);
        }
    }

    public void updateAccount() {
        System.out.println("Enter Id of your account");
        int id = scanner.nextInt();
        System.out.println("Enter name ");
        String name = scanner.next();
        System.out.println("Enter new password ");
        String password = scanner.next();
        accountFunctional.update(id, name, password);
    }

    public void deleteAccount() {
        System.out.println("Enter Id");
        int id = scanner.nextInt();
        accountFunctional.deleteAccount(id);
    }

    public void addAccount() {
        System.out.println("Print nickname");
        String nickname = scanner.next();
        System.out.println("Print password");
        String password = scanner.next();
        System.out.println("Print ownerId");
        int ownerId = scanner.nextInt();
        accountFunctional.addAccount(nickname, password, ownerId);
    }
}

