package ua.univer.DemoApp.net;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final Integer PORT = 8899;
    @SneakyThrows
    public static void main(String[] args) {
        try(var socket = new Socket(InetAddress.getLocalHost().getHostAddress(), PORT)) {
            var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            try(Scanner scanner = new Scanner(System.in)) {
                var message = scanner.nextLine();
                writer.write(message);
                writer.flush();
            }
        }
    }
}
