package classLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.info("""
                Choose which class load.
                If you enter 1, will load class Hello.
                If you enter 2, will load class Loop.""");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 1) {
            log.info(Hello.start());
        } else if (num == 2) {
            log.info("Enter size of loop");
            int size = scanner.nextInt();
            Loop.start(size);
            log.info(Loop.start(size));
        } else {
            log.info("No class found");
        }
    }

}

