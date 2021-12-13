package com.sql;


import com.sql.dao.DbMethods;
import com.sql.dao.impl.NoSQLMethodsImpl;
import com.sql.dao.impl.SQLMethodsImpl;
import com.sql.menu.NoSQLMenu;
import com.sql.menu.SQLMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final DbMethods sqlFunctional = new SQLMethodsImpl();
        final SQLMenu sqlMenu = new SQLMenu(scanner, sqlFunctional);
        final DbMethods noSQLFunctional = new NoSQLMethodsImpl();
        final NoSQLMenu noSQLMenu = new NoSQLMenu(noSQLFunctional, scanner);

        System.out.println("If you want to use SQL press 1\n" +
                "If you want to use NoSQL press 2");
        int selection = scanner.nextInt();
        if (selection == 1) {
            sqlMenu.start();
        }
        if (selection == 2) {
            noSQLMenu.start();
        }
    }
}