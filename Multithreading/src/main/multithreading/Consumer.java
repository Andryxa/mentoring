package main.multithreading;

public class Consumer implements Runnable {

    @Override
    public void run() {
        SharedResource res = SharedResource.getInstance();
        while (true) {
            if (res.getResource() > 5) {
                res.minus();
            } else break;
        }
    }
}



