package ua.DemoApp;

import lombok.extern.java.Log;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

@Log
public class DemoApp {

    public static void main(String[] args) {
        var enhancer = new Enhancer();
        enhancer.setSuperclass(Randomizer.class);
        enhancer.setCallback((MethodInterceptor)(obj, method, methodArgs, proxy) -> {
            if (method.getName().equals("randomize")) {
                log.info("Calling method from CGLib Proxy");
                return proxy.invokeSuper(obj, methodArgs);
            }
            throw new UnsupportedOperationException();
        });
        var proxyInstance = (Randomizer) enhancer.create();
        testRandomizer(proxyInstance, List.of(1, 2, 3, 4, 5));
    }

    public static void testRandomizer(Randomizer randomizer, List<?> list){
        log.info(String.valueOf(randomizer.randomize(list)));
    }
}
