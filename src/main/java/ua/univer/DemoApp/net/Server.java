package ua.univer.DemoApp.net;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Log
public class Server {

    private static final Integer THREAD_AMOUNT = 40;
    private static final Integer PORT = 8899;
    private static final Integer SLEEP_TIME = 5;

    private static void sleep(HashSet<String> users){
        CompletableFuture.runAsync(() -> {
            while (true) {
                log.info("Unique users: " + users.size());
                try {
                    TimeUnit.SECONDS.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SneakyThrows
    private static void runServer() {
        var users = new HashSet<String>();
        var threads = new ArrayList<Thread>();
        sleep(users);
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            for (int i = 0; i < THREAD_AMOUNT; i++) {
                var t = new Thread(() -> {
                    try (var client = serverSocket.accept()){
                        var reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        var line = reader.readLine();
                        String clientAddress = client.getInetAddress().getHostAddress();
                        log.info(clientAddress + " - " + line);
                        users.add(clientAddress);
                    } catch(Exception e) {
                        log.info(String.valueOf(e));
                    }
                });
                t.start();
                threads.add(t);
            }
            threads.forEach(t -> {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        runServer();
    }
}
