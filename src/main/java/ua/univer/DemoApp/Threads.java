package ua.univer.DemoApp;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.concurrent.TimeUnit;

@Log
public class Threads {
    @SneakyThrows
    public static void main(String[] args) {
        var s1 = new Stats();
        var s2 = new Stats();

        // deadlock
        var t1 = new Thread(() -> {
            synchronized(s1) {
                sleepSeconds(1);
                s2.increment();
            }
        });
        var t2 = new Thread(() -> {
            synchronized (s2) {
                s1.increment();
            }
        });

        var statePrinter = new Thread(() -> {
            while (true) {
                log.info(String.valueOf(t1.getState()));
                log.info(String.valueOf(t2.getState()));
                sleepSeconds(1);
            }
        });

        statePrinter.start();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    @SneakyThrows
    public static void sleepSeconds(int seconds) {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
