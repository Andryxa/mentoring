package main.multithreading;

public class Consumer implements Runnable {

    @Override
    public void run() {
        SharedResource res = SharedResource.getInstance();
        try {
            while (true) {
                if (res.getResource() > 5) {
                    res.minus();
                    Thread.sleep(20);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



