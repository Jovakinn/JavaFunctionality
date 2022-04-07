package ua.univer.DemoApp;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Log
public class ExecutorsDemo {

    public static void main(String[] args) {
        var voidCompletableFuture = CompletableFuture
                .supplyAsync(ExecutorsDemo::getValueFromAnotherService)
                .thenApply(Integer::parseInt)
                .thenAccept(a -> log.info(String.valueOf(a)));
        log.info("I am not blocked");
        voidCompletableFuture.join();
    }

    @SneakyThrows
    private static String getValueFromAnotherService() {
        TimeUnit.SECONDS.sleep(1);
        return "17";
    }
}
