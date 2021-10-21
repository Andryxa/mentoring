package main.classLoader;

public class Loop {
    public static void start(int size) {
        String[] loop = new String[size];
        for (int i = 0; i < size; i++) {
            loop[i] = "A";
            System.out.println(loop[i]);
        }
    }
}
