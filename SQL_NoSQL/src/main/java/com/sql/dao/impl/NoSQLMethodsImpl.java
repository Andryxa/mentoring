package com.sql.dao.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sql.dao.DbMethods;
import org.bson.Document;

import java.util.*;

public class NoSQLMethodsImpl implements DbMethods {
    private MongoDatabase database;


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
        MongoCollection<Document> collection = database.getCollection("users");
        var newDocument = new Document(Map.of("name", surname));
        collection.insertOne(newDocument);
    }

    @Override
    public void deleteUser(int id) {
        MongoCollection<Document> collection = database.getCollection("users");
        var newDocument = new Document(Map.of("id", id));
        collection.findOneAndDelete(newDocument);
    }

    @Override
    public List searchUser(String surname) {
        List search = new ArrayList();
        MongoCollection<Document> collection = database.getCollection("users");
        collection.find(new Document("name", new Document("$regex", surname)))
                .into(search);
        return search;
    }

    @Override
    public List showAll(String table) {
        List list = new ArrayList();
        MongoCollection<Document> collection = database.getCollection(table);
        collection.find().into(list);
        return list;
    }

    @Override
    public List availableBooks() {
        List booksList = new ArrayList();
        MongoCollection<Document> collection = database.getCollection("books");
        collection.find(Filters.eq("available", true))
                .into(booksList);
        return booksList;
    }


}