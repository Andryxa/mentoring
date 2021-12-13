package com.sql.menu;

import com.sql.dao.DbMethods;

import java.util.List;
import java.util.Scanner;

public class SQLMenu {
    private final DbMethods methods;
    private final Scanner scanner;
    private String table;


    public SQLMenu(Scanner scanner, DbMethods methods) {
        this.methods = methods;
        this.scanner = scanner;
    }

    public void start() {

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
                        If you want search user by surname press 4\s
                        If you want to close the program press 0\s""");
                int method = scanner.nextInt();
                switch (method) {
                    case 1 -> printAll();
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
                        If you want to close the program press 0\s
                        """);
                int method = scanner.nextInt();
                switch (method) {
                    case 1 -> printAll();
                    case 2 -> availableBooks();
                }
                if (method == 0) {
                    break;
                }
            }
        }
    }

    private void searchUser() {
        System.out.println("Enter user surname");
        String surname = scanner.next();
        List<String> search = methods.searchUser(surname);
        search.forEach(System.out::println);
    }

    private void availableBooks() {
        List<String> books = methods.availableBooks();
        books.forEach(System.out::println);
    }

    private void printAll() {
        List<String> all = methods.showAll(table);
        all.forEach(System.out::println);

    }

    private void deleteUser() {
        System.out.println("Enter user ID ");
        int id = scanner.nextInt();
        methods.deleteUser(id);
    }

    private void addUser() {
        System.out.println("Insert surname");
        String surname = scanner.next();
        methods.addUser(surname);
    }
}