package com.sql.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.sql.menu.ConnectionToSQL.stmt;

public class SQLFunctional {

    public static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void showAll(String table) throws SQLException {
        String query = "select * from " + table;
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.printf("id: %d, name: %s ", id, name);
            System.out.println();
        }
    }

    public static void addNewUser() {
        System.out.println("Insert surname");
        try {
            String query = "INSERT INTO library.users (name) \n" +
                    "VALUES ('" + scanner.next() + "');";
            stmt.executeUpdate(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void deleteUser() {
        System.out.println("Enter user ID ");
        int idToDelete = scanner.nextInt();
        String query = "delete from users where ID = " + idToDelete + ";";
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchUser() {
        System.out.println("Enter user ID");
        int idToSearch = scanner.nextInt();
        String query = "select name from users where ID = " + idToSearch + ";";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.printf("id: %d, surname: %s ", idToSearch, name);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAvailableBooks() {
        String query = "select id, name from books where using_by = 1;";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.printf("id: %d, name: %s ", id, name);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
