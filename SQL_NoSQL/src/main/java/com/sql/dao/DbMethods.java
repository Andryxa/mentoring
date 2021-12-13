package com.sql.dao;

import java.util.List;

public interface DbMethods {

    void connect();

    void addUser(String surname);

    void deleteUser(int id);

    List searchUser(String surname);

    List showAll(String table);

    List availableBooks();
}