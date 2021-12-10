package com.sql;


import com.sql.dao.Functional;
import com.sql.dao.impl.NoSQLFunctionalImpl;
import com.sql.dao.impl.SQLFunctionalImpl;
import com.sql.menu.NoSQLMenu;
import com.sql.menu.SQLMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Functional  sqlFunctional= new SQLFunctionalImpl();
        final SQLMenu sqlMenu = new SQLMenu(scanner, sqlFunctional);
        final Functional noSQLFunctional = new NoSQLFunctionalImpl();
        final NoSQLMenu noSQLMenu = new NoSQLMenu(noSQLFunctional, scanner);

        System.out.println("If you want to use SQL press 1\n" +
                "If you want to use NoSQL press 2");
        int selection = scanner.nextInt();
        if (selection == 1) {
            sqlMenu.start();
        } else if (selection == 2) {
           noSQLMenu.start();
        }
    }
}