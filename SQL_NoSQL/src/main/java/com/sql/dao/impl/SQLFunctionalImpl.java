package com.sql.dao.impl;

import com.sql.dao.Functional;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;


public class SQLFunctionalImpl implements Functional {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to MySQL successfully!");
            statement = connection.createStatement();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | SQLException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(String surname) {
        String query = "INSERT INTO library.users (name) \n" +
                "VALUES ('" + surname + "');";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String query = "delete from users where ID = " + id + ";";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchUser(String surname) {
        String query = "select id, name from users where name = '" + surname + "';";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.printf("id: %d, surname: %s ", id, name);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll(String table) {
        String query = "select * from " + table;
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.printf("id: %d, name: %s ", id, name);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void availableBooks() {
        String query = "select id, name from books where using_by = 1;";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.printf("id: %d, name: %s ", id, name);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
