package com.sql.menu;

import com.sql.dao.Functional;

import java.util.Scanner;

public class SQLMenu {
    private final Functional functional;
    private final Scanner scanner;
    private String table;


    public SQLMenu(Scanner scanner, Functional functional) {
        this.functional = functional;
        this.scanner = scanner;
    }

    public void start() {
        connect();

        System.out.println("If you want to use table 'users' press 1 \n" +
                "If you want to use table 'books' press 2");
        int tableChoice = scanner.nextInt();

        while (true) {
            if (tableChoice == 1) {
                table = "users";
                System.out.println("""
                        \sIf you want to show all users press 1\s
                        If you want to add new user press 2\s
                        If you want to delete user press 3\s
                        If you want search user by ID press 4\s
                        If you want to close the program press 0\s""");
                int method = scanner.nextInt();
                if (method == 1) {
                    printAll();
                } else if (method == 2) {
                    addUser();
                } else if (method == 3) {
                    deleteUser();
                } else if (method == 4) {
                    searchUser();

                } else if (method == 0) {
                    break;
                }
            } else if (tableChoice == 2) {
                table = "books";
                System.out.println("""
                        If you want to show all books press 1\s
                        If you want to show available books press 2\s
                        If you want to close the program press 0\s
                        """);
                int method = scanner.nextInt();
                if (method == 1) {
                    printAll();
                } else if (method == 2) {
                    availableBooks();
                } else if (method == 0) {
                    break;
                }
            }
        }
    }

    private void connect() {
        functional.connect();
    }

    private void searchUser() {
        System.out.println("Enter user surname");
        String surname = scanner.next();
        functional.searchUser(surname);
    }

    private void availableBooks() {
        functional.availableBooks();
    }

    private void printAll() {
        functional.showAll(table);
    }

    private void deleteUser() {
        System.out.println("Enter user ID ");
        int id = scanner.nextInt();
        functional.deleteUser(id);
    }

    private void addUser() {
        System.out.println("Insert surname");
        String surname = scanner.next();
        functional.addUser(surname);
    }
}

