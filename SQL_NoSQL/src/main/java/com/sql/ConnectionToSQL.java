package main.java.com.sql;

import java.sql.*;
import java.util.Scanner;

public class ConnectionToSQL {

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "password";

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            //connection
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to MySQL successfully!");

            // getting Statement object to execute query
            stmt = con.createStatement();

            //choose table
            System.out.println("If you want to use table 'users' press 1 \n" +
                    "If you want to use table 'books' press 2");
            int table = scanner.nextInt();

            while (scanner.nextLine() != "q") {
                if (table == 1) {
                    //methods of users
                    System.out.println("If you want to show all users press 1 \n" +
                            "If you want to add new user press 2 \n" +
                            "If you want to delete user press 3 \n" +
                            "If you want search user by ID press 4");
                    int method = scanner.nextInt();
                    if (method == 1) {
                        String query = "select * from users";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String name = rs.getString(2);
                            System.out.printf("id: %d, name: %s ", id, name);
                            System.out.println();
                        }
                        //Add new user
                    } else if (method == 2) {
                        System.out.println("Insert surname");

                        try {
                            String query = "INSERT INTO library.users (name) \n" +
                                    "VALUES ('" + scanner.nextLine() + "');";
                            stmt.executeUpdate(query);
                        } catch (SQLException throwable) {
                            throwable.printStackTrace();
                        }
                        //Delete user
                    } else if (method == 3) {
                        System.out.println("Enter user ID ");
                        int idToDelete = scanner.nextInt();
                        String query = "delete from users where ID = " + idToDelete + ";";
                        stmt.executeUpdate(query);
                        //Search user
                    } else if (method == 4) {
                        System.out.println("Enter user ID");
                        int idToSearch = scanner.nextInt();
                        String query = "select name from users where ID = " + idToSearch + ";";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            String name = rs.getString(1);
                            System.out.printf("id: %d, surname: %s ", idToSearch, name);
                            System.out.println();
                        }
                    }
                }
                if (table == 2) {
                    System.out.println("If you want to show all books press 1 \n" +
                            "If you want to show available books press 2 \n");
                    int method = scanner.nextInt();
                    if (method == 1) {
                        String query = "select * from books";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String name = rs.getString(2);
                            System.out.printf("id: %d, name: %s ", id, name);
                            System.out.println();
                        }
                    } else if (method == 2) {
                        String query = "select id, name from books where using_by = 1;";
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String name = rs.getString(2);
                            System.out.printf("id: %d, name: %s ", id, name);
                            System.out.println();
                        }
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
