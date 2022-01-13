package ua.univer.lesson05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Program {

    public static int sub(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        BiFunction<Integer, Integer, String> sumOp = (x, y) -> String.valueOf(x + y);
        BiFunction<Integer, Integer, Integer> multiOp = (x, y) -> x * y;
        BiFunction<Integer, Integer, Integer> subOp = (x, y) -> x - y;
        BiFunction<Integer, Integer, Integer> sub = Program::sub;

        System.out.println(sumOp.apply(a, b));
        System.out.println(multiOp.apply(a, b));
        System.out.println(subOp.apply(a, b));


        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.forEach(System.out::println);


    }
}
