package com.andryxa.mentoring;

import com.andryxa.mentoring.dao.ClientsAndAccounts;
import com.andryxa.mentoring.menu.AccountMenu;
import com.andryxa.mentoring.menu.ClientMenu;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("If you want to work with table 'clients' press 1\n" +
                "If you want to work with table 'accounts' press 2\n" +
                "Шf you want to see all clients and their accounts press 3");
        int choice = scanner.nextInt();
        if (choice == 1) {
            ClientMenu.start();
        } else if (choice == 2) {
            AccountMenu.start();
        } else if (choice == 3) {
            ClientsAndAccounts.start();
        }
    }
}