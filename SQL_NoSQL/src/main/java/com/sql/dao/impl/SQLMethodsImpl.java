package com.sql.dao.impl;

import com.sql.dao.DbMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLMethodsImpl implements DbMethods {

    private Connection connection;
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(String surname) {
        String query = "INSERT INTO library.users (name) \n" +
                "VALUES ('" + surname + "');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String query = "delete from users where ID = " + id + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List searchUser(String surname) {
        List search = new ArrayList();
        String query = "select * from users where name = '" + surname + "';";
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String user = ("id:" + id + " surname: " + name);
                search.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return search;
    }

    @Override
    public List showAll(String table) {
        List list = new ArrayList();
        String query = "select * from " + table;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String all = ("id: " + id + " name: " + name);
                list.add(all);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List availableBooks() {
        List booksList = new ArrayList();
        String query = "SELECT id, name FROM books WHERE using_by = 1;";
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String books = ("id: " + id + " name: " + name);
                booksList.add(books);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
}
