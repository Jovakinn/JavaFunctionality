package ua.demo;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

@Log
public class MorningClient {
    private static final Integer PORT = 8899;

    @SneakyThrows
    public static void main(String[] args) {
        var ip = InetAddress.getLocalHost().getHostAddress();
        try(var clientSocket = new Socket(ip, PORT)) {
            var printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            printWriter.println("GET /JavaFunctionality_war/morning?name=Maksym HTTP/1.1");
            printWriter.println("Host: " + ip);
            printWriter.println();
            printWriter.flush();
            var inputStream = clientSocket.getInputStream();
            var in = new InputStreamReader(inputStream);
            var bufferedReader = new BufferedReader(in);
            bufferedReader.lines().forEach(log::info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
