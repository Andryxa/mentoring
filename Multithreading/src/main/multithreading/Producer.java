package main.multithreading;

public class Producer implements Runnable {

    @Override
    public void run() {
        SharedResource res = SharedResource.getInstance();
        while (true) {
            if (res.getResource() < 10) {
                res.plus();
            } else break;
        }
    }
}
