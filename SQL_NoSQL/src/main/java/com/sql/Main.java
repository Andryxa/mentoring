package main.java.com.sql;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to use SQL press 1\n" +
                "If you want to use NoSQL press 2");
        int selection = scanner.nextInt();
        if (selection == 1) {
            ConnectionToSQL connectionToSQL = new ConnectionToSQL();
            connectionToSQL.start();
        } else if (selection == 2) {
            ConnectionToNoSQL connectionToNoSQL = new ConnectionToNoSQL();
            connectionToNoSQL.start();
        }
    }
}