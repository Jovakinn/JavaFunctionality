package ua.univer.DemoApp;

import lombok.extern.java.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Log
public class ExecutorsDemo {
    private static final int THREADS_AMOUNT = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);
        Runnable runnableTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                log.info("Hello from runnable task");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.SECONDS.sleep(3);
            return "Task execution";
        };

        executor.execute(runnableTask);
        executor.shutdown();
    }
}
