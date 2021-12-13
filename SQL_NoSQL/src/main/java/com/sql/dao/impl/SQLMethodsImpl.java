package com.sql.dao.impl;

import com.sql.dao.DbMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLMethodsImpl implements DbMethods {

    private final String username;
    private final String password;
    private final String url;


    public SQLMethodsImpl(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }


    @Override
    public void addUser(String surname) {

        Connection connection = getConnection();
        Statement statement = null;
        String query = "INSERT INTO library.users (name) \n" +
                "VALUES ('" + surname + "');";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
    }

    public static void close(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection connection = getConnection();
        Statement statement = null;
        String query = "delete from users where ID = " + id + ";";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
    }

    @Override
    public List<String> searchUser(String surname) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet;
        List<String> search = new ArrayList<>();
        String query = "select * from users where name = '" + surname + "';";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String user = ("id:" + id + " surname: " + name);
                search.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
        return search;
    }

    @Override
    public List<String> showAll(String table) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet;
        List<String> list = new ArrayList<>();
        String query = "select * from " + table;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String all = ("id: " + id + " name: " + name);
                list.add(all);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
        return list;
    }

    @Override
    public List<String> availableBooks() {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet;
        List<String> booksList = new ArrayList<>();
        String query = "SELECT id, name FROM books WHERE using_by = 1;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String books = ("id: " + id + " name: " + name);
                booksList.add(books);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
        return booksList;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}