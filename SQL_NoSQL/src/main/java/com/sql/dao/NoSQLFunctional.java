package com.sql.dao;

import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.sql.menu.ConnectionToNoSQL.collection;

public class NoSQLFunctional {
    private static Scanner scanner = new Scanner(System.in);

    public static void showAll() {
        collection.find()
                .forEach((Consumer<Document>) System.out::println);
    }

    public static void addNewUser() {
        System.out.println("Enter name");
        String name = scanner.next();
        var newDocument = new Document(Map.of("name", name));
        collection.insertOne(newDocument);
    }

    public static void deleteUser() {
        System.out.println("Enter name");
        String name = scanner.next();
        var newDocument = new Document(Map.of("name", name));
        collection.findOneAndDelete(newDocument);
    }

    public static void searchUser() {
        System.out.println("Enter name");
        String name = scanner.next();
        collection.find(new Document("name", new Document("$regex", name)))
                .forEach((Consumer<Document>) System.out::println);
    }

    public static void availableBooks() {
        collection.find(Filters.eq("available", true))
                .forEach((Consumer<Document>) System.out::println);
    }
}
