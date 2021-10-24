package main.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread consumer = new Thread(new Consumer());
        consumer.start();
        consumer.join(100);
        Thread producer = new Thread(new Producer());
        producer.start();
    }
}
