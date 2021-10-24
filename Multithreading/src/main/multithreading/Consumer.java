package main.multithreading;

public class Consumer implements Runnable {

    @Override
    public void run() {
        SharedResource res = new SharedResource();
        res.minus();
    }
}



