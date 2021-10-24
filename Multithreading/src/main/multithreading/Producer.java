package main.multithreading;

public class Producer implements Runnable {

    @Override
    public void run() {
        SharedResource res = new SharedResource();
        res.plus();
    }
}
