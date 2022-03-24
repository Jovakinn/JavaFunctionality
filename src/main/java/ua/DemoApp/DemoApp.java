package ua.DemoApp;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Log
public class DemoApp {

    @SneakyThrows
    public static void main(String[] args) {
        var randomizerInterface = Class.forName("ua.DemoApp.Randomizer");
        var classLoader = randomizerInterface.getClassLoader();
        var interfacesToImplement = new Class<?>[]{randomizerInterface};
        InvocationHandler handler = (proxy, method, args1) -> {
            if (method.getName().equals("randomize")) {
                var list = (List<?>) args1[0];
                var index = ThreadLocalRandom.current().nextInt(list.size());
                return list.get(index);
            }
            throw new UnsupportedOperationException();
        };

        var randomizerInstance = Proxy.newProxyInstance(classLoader, interfacesToImplement, handler);
        var randomizeMethod = randomizerInstance.getClass().getMethod("randomize", List.class);
        var result = randomizeMethod.invoke(randomizerInstance, List.of(1, 23, 45, 67, 900));
        log.info(String.valueOf(result));
    }
}
