package main.java.com.sql;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Scanner;

public class ConnectionToNoSQL {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
                MongoDatabase database = mongoClient.getDatabase("library");
                try {
                    Bson command = new BsonDocument("ping", new BsonInt64(1));
                    Document commandResult = database.runCommand(command);
                    System.out.println("Connected successfully to server.");
                } catch (MongoException me) {
                    System.err.println("An error occurred while attempting to run a command: " + me);
                }


                System.out.println("If you want to use collection 'users' press 1 \n" +
                        "If you want to use collection 'books' press 2");
                int coll = scanner.nextInt();

                if (coll == 1) {
                } else if (coll == 2) {
                    DBCollection collection = (DBCollection) database.getCollection("books");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {

        }
    }
}
