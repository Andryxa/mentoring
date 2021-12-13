package com.sql.dao;

import java.util.List;

public interface DbMethods {

    void connect();

    void addUser(String surname);

    void deleteUser(int id);

    List<String> searchUser(String surname);

    List<String> showAll(String table);

    List<String> availableBooks();
}