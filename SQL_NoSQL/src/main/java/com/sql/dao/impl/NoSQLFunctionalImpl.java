package com.sql.dao.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sql.dao.Functional;
import org.bson.Document;

import java.util.Map;
import java.util.function.Consumer;


public class NoSQLFunctionalImpl implements Functional {
    private MongoDatabase database;
    private MongoCollection<Document> collection;


    @Override
    public void connect() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDatabase("library");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(String surname) {
        collection = database.getCollection("users");
        var newDocument = new Document(Map.of("name", surname));
        collection.insertOne(newDocument);
    }

    @Override
    public void deleteUser(int id) {
        collection = database.getCollection("users");
        var newDocument = new Document(Map.of("id", id));
        collection.findOneAndDelete(newDocument);
    }

    @Override
    public void searchUser(String surname) {
        collection = database.getCollection("users");
        collection.find(new Document("name", new Document("$regex", surname)))
                .forEach((Consumer<Document>) System.out::println);
    }

    @Override
    public void showAll(String table) {
        collection = database.getCollection(table);
        collection.find()
                .forEach((Consumer<Document>) System.out::println);
    }

    @Override
    public void availableBooks() {
        collection = database.getCollection("books");
        collection.find(Filters.eq("available", true))
                .forEach((Consumer<Document>) System.out::println);
    }

}
