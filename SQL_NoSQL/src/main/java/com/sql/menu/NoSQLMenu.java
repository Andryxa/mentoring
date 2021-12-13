package com.sql.menu;

import com.sql.dao.DbMethods;

import java.util.List;
import java.util.Scanner;


public class NoSQLMenu {
    private final DbMethods methods;
    private final Scanner scanner;
    private String table;


    public NoSQLMenu(DbMethods methods, Scanner scanner) {
        this.methods = methods;
        this.scanner = scanner;
    }

    public void start() {
        methods.connect();

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
                switch (method) {
                    case 1 -> showAll();
                    case 2 -> addUser();
                    case 3 -> deleteUser();
                    case 4 -> searchUser();
                }
                if (method == 0) {
                    break;
                }
            }
            if (tableChoice == 2) {
                table = "books";
                System.out.println("""
                        If you want to show all books press 1\s
                        If you want to show available books press 2\s
                        If you want to close the program press 0
                        """);
                int method = scanner.nextInt();
                switch (method) {
                    case 1 -> showAll();
                    case 2 -> availableBooks();
                }
                if (method == 0) {
                    break;
                }
            }
        }
    }

    private void availableBooks() {
        List books = methods.availableBooks();
        books.forEach((s) -> System.out.println(s));
    }

    private void showAll() {
        List list = methods.showAll(table);
        list.forEach((s) -> System.out.println(s));
    }

    private void searchUser() {
        System.out.println("Enter name");
        String surname = scanner.next();
        List search = methods.searchUser(surname);
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i));
        }
    }

    private void deleteUser() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        methods.deleteUser(id);
    }

    private void addUser() {
        System.out.println("Enter name");
        String surname = scanner.next();
        methods.addUser(surname);
    }
}