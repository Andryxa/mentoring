package com.sql.menu;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

import static com.sql.dao.NoSQLFunctional.*;

public class ConnectionToNoSQL {

    private static final Scanner scanner = new Scanner(System.in);
    public static MongoCollection<Document> collection;

    public void start() {
        try {
            try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
                MongoDatabase database = mongoClient.getDatabase("library");
                try {
                    System.out.println("Connected successfully to server.");
                } catch (MongoException me) {
                    System.err.println("An error occurred while attempting to run a command: " + me);
                }


                System.out.println("If you want to use collection 'users' press 1 \n" +
                        "If you want to use collection 'books' press 2");
                int coll = scanner.nextInt();

                if (coll == 1) {
                    collection = database.getCollection("users");
                    System.out.println("""
                            If you want to show all users press 1\s
                            If you want to add new user press 2\s
                            If you want to delete user press 3\s
                            If you want search user by name press 4""");
                    int method = scanner.nextInt();

                    if (method == 1) {
                        showAll();
                    } else if (method == 2) {
                        addNewUser();
                    } else if (method == 3) {
                        deleteUser();
                    } else if (method == 4) {
                        searchUser();
                    }
                } else if (coll == 2) {
                    collection = database.getCollection("books");
                    System.out.println("""
                            If you want to show all books press 1\s
                            If you want to show available books press 2\s
                            """);
                    int method = scanner.nextInt();
                    if (method == 1) {
                        showAll();
                    } else if (method == 2) {
                        availableBooks();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

