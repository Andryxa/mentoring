package main.multithreading;

public class Main {
    public static void main(String[] args) {
        Thread consumer = new Thread(new Consumer());
        Thread producer = new Thread(new Producer());
        consumer.start();
        producer.start();
    }
}