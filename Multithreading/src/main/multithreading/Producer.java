package main.multithreading;

public class Producer implements Runnable {

    @Override
    public void run() {
        SharedResource res = SharedResource.getInstance();
        try {
            while (true) {
                if (res.getResource() < 10) {
                    res.plus();
                    Thread.sleep(20);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
