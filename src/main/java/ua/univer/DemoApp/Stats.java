package ua.univer.DemoApp;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Stats {
    private volatile Long counter = 0L;

    @SneakyThrows
    public synchronized void increment() {
        counter++;
        TimeUnit.SECONDS.sleep(5);
    }

    public Long counter() {
        return counter;
    }
}
