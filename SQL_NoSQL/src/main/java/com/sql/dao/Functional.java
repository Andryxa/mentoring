package com.sql.dao;

public interface Functional {

    void connect();

    void addUser(String surname);

    void deleteUser(int id);

    void searchUser(String surname);

    void showAll(String table);

    void availableBooks();
}
