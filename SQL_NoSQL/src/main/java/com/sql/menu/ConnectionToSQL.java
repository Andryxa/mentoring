package com.sql.menu;

import java.sql.*;
import java.util.Scanner;

import static com.sql.dao.SQLFunctional.*;

public class ConnectionToSQL {

    private static final String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "password";

    public static Connection con;
    public static Statement stmt;
    private static Scanner scanner = new Scanner(System.in);
    String table;
    int tableChoice;

    public void start() {
        try {
            //connection
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to MySQL successfully!");
            stmt = con.createStatement();

            System.out.println("If you want to use table 'users' press 1 \n" +
                    "If you want to use table 'books' press 2");
            tableChoice = scanner.nextInt();

            while (!scanner.nextLine().equals("q")) {
                if (tableChoice == 1) {
                    table = "users";
                    System.out.println("""
                            If you want to show all users press 1\s
                            If you want to add new user press 2\s
                            If you want to delete user press 3\s
                            If you want search user by ID press 4\s
                            If you want to quit press q""");
                    int method = scanner.nextInt();
                    if (method == 1) {
                        showAll(table);
                    } else if (method == 2) {
                        addNewUser();
                    } else if (method == 3) {
                        deleteUser();
                    } else if (method == 4) {
                        searchUser();
                    }
                }
                if (tableChoice == 2) {
                    table = "books";
                    System.out.println("""
                            If you want to show all books press 1\s
                            If you want to show available books press 2\s
                            """);
                    int method = scanner.nextInt();
                    if (method == 1) {
                        showAll(table);
                    } else if (method == 2) {
                        showAvailableBooks();
                    }
                }
            }
        } catch (
                Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
