package main.classLoader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose which class load.
                If you enter 1, will load class Hello.
                If you enter 2, will load class Loop.""");
        int num = scanner.nextInt();
        if (num == 1) {
            Hello.say();
        } else if (num == 2) {
            System.out.println("Enter size of loop");
            int size = scanner.nextInt();
            Loop.start(size);
        } else {
            System.out.println("No class found");
        }
    }

}

