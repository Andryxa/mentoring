package main.multithreading;


import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    ReentrantLock locker = new ReentrantLock();
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
        locker.lock();
        try {
            resource--;
            System.out.println("minus 1, left: " + resource);
        } finally {
            locker.unlock();
        }

    }

    public void plus() {
        locker.lock();
        try {
            resource++;
            System.out.println("plus 1, left: " + resource);
        } finally {
            locker.unlock();
        }

    }

    public int getResource() {
        return resource;
    }
}