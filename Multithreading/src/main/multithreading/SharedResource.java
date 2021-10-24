package main.multithreading;

public class SharedResource {

    private static int resource = 10;

    public void minus() {
        while (true) {
            if (resource > 5) {
                resource--;
                System.out.println("minus 1, left: " + resource);
            } else break;
        }
    }

    public void plus() {
        while (true) {
            if (resource < 10) {
                resource++;
                System.out.println("plus 1, left: " + resource);
            } else break;
        }
    }

}
