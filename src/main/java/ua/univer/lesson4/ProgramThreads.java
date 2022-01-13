package ua.univer.lesson4;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("My thread " + Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("My thread " + Thread.currentThread().getName() + " end");
    }
}

class MyRunnble implements Runnable {

    @Override
    public void run() {
        System.out.println("My runnable " + Thread.currentThread().getName() + " start");
        System.out.println("My runnable " + Thread.currentThread().getName() + " end");
    }
}

public class ProgramThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new MyThread();
        th1.start();
        Thread th2 = new Thread(new MyRunnble());
        th2.start();

        new Thread(() -> {
            System.out.println("Anonymous " + Thread.currentThread().getName() + " start");
            System.out.println("Anonymous " + Thread.currentThread().getName() + " end");
        }).start();

        Thread th3 = new Thread(() -> {
            System.out.println("Anonymous " + Thread.currentThread().getName() + " start");
            while (!Thread.interrupted()) {
                System.out.println(LocalDateTime.now());
            }
            System.out.println("Anonymous " + Thread.currentThread().getName() + " end");
        });
        th3.start();

        th1.join();
        th3.interrupt();
        System.out.println("main " + Thread.currentThread().getName() + " end");

        Executor thPool = Executors.newSingleThreadExecutor();
        thPool.execute(() -> {
            System.out.println("ThPool " + Thread.currentThread().getName() + " start");
            System.out.println("ThPool " + Thread.currentThread().getName() + " end");
        });
    }
}
