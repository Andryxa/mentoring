package com.sql.dao.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sql.dao.DbMethods;
import org.bson.Document;

import java.util.*;

public class NoSQLMethodsImpl implements DbMethods {
    private final String host;
    private final int port;
    private final String databaseName;

    public NoSQLMethodsImpl(String host, int port, String databaseName) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
    }

    public MongoDatabase getDatabase() {
        MongoDatabase database = null;
        try {
            MongoClient mongoClient = new MongoClient(host, port);
            database = mongoClient.getDatabase(databaseName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return database;
    }

    @Override
    public void addUser(String surname) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("users");
        var newDocument = new Document(Map.of("name", surname));
        collection.insertOne(newDocument);
    }

    @Override
    public void deleteUser(int id) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("users");
        var newDocument = new Document(Map.of("id", id));
        collection.findOneAndDelete(newDocument);
    }

    @Override
    public List searchUser(String surname) {
        List search = new ArrayList<>();
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("users");
        collection.find(new Document("name", new Document("$regex", surname)))
                .into(search);
        return search;
    }

    @Override
    public List showAll(String table) {
        List list = new ArrayList();
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection(table);
        collection.find().into(list);
        return list;
    }

    @Override
    public List availableBooks() {
        List booksList = new ArrayList();
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("books");
        collection.find(Filters.eq("available", true))
                .into(booksList);
        return booksList;
    }
}