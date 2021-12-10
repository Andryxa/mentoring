package com.sql.menu;

import com.sql.dao.Functional;

import java.util.Scanner;


public class NoSQLMenu {
    private final Functional functional;
    private final Scanner scanner;
    private String table;


    public NoSQLMenu(Functional functional, Scanner scanner) {
        this.functional = functional;
        this.scanner = scanner;
    }

    public void start() {
        functional.connect();

        System.out.println("If you want to use collection 'users' press 1 \n" +
                "If you want to use collection 'books' press 2");
        int tableChoice = scanner.nextInt();
        while (true) {
            if (tableChoice == 1) {
                table = "users";
                System.out.println("""
                        If you want to show all users press 1\s
                        If you want to add new user press 2\s
                        If you want to delete user press 3\s
                        If you want search user by name press 4\s
                        If you want to close the program press 0""");
                int method = scanner.nextInt();

                if (method == 1) {
                    showAll();
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
                        If you want to close the program press 0
                        """);
                int method = scanner.nextInt();
                if (method == 1) {
                    showAll();
                } else if (method == 2) {
                    availableBooks();
                } else if (method == 0) {
                    break;
                }
            }
        }
    }

    private void availableBooks() {
        functional.availableBooks();
    }

    private void showAll() {
        functional.showAll(table);
    }

    private void searchUser() {
        System.out.println("Enter name");
        String surname = scanner.next();
        functional.searchUser(surname);
    }

    private void deleteUser() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        functional.deleteUser(id);
    }

    private void addUser() {
        System.out.println("Enter name");
        String surname = scanner.next();
        functional.addUser(surname);
    }
}
