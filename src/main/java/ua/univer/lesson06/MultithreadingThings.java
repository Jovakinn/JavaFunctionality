package ua.univer.lesson06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class MultithreadingThings {
    private static final Logger logger = Logger.getLogger(MultithreadingThings.class.getName());
    private static final Lock MUTEX = new ReentrantLock();

    static boolean flag;

    void m(boolean flag) {
        try {
            MUTEX.lock();
            MultithreadingThings.flag = flag;

            try { sleep(200); }
            catch (InterruptedException e) { e.printStackTrace(); }

            logger.info(MultithreadingThings.flag + " == " + flag);
        } finally {
            MUTEX.unlock();
        }
    }

    public static void main(String[] args) {
        MultithreadingThings multithreadingThings
                = new MultithreadingThings();

        new Thread(() -> {
          while (true) {
              multithreadingThings.m(false);
              try {
                  Thread.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }).start();

        new Thread(() -> {
            while (true) {
                multithreadingThings.m(true);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
