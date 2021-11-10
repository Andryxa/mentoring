package main.multithreading;


public class SharedResource {

    private int resource = 10;
    private static SharedResource instance;

    private SharedResource() {
    }

    public static SharedResource getInstance() {
        if (instance == null) {
            instance = new SharedResource();
        }
        return instance;
    }

    public void minus() {
        synchronized (instance) {
            resource--;
            System.out.println("minus 1, left: " + resource);
        }
    }

    public void plus() {
        synchronized (instance) {
            resource++;
            System.out.println("plus 1, left: " + resource);
        }
    }

    public synchronized int getResource() {
        return resource;
    }
}
