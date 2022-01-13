package ua.univer.lesson06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class MyList implements Iterator<Integer> {
    private static final Logger logger = Logger.getLogger(MyList.class.getName());
    private int[] arr;
    private int i;

    public MyList(int[] arr) {
        this.arr = arr;
        i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < arr.length;
    }

    @Override
    public Integer next() {
        return arr[i + 1];
    }

    public MyList(int[] arr, int i) {
        this.arr = arr;
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyList)) return false;

        MyList myList = (MyList) o;

        if (i != myList.i) return false;
        return Arrays.equals(arr, myList.arr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arr);
        result = 31 * result + i;
        return result;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "arr=" + Arrays.toString(arr) +
                ", i=" + i +
                '}';
    }


    public static void main(String[] args)  {
        Map<Integer, String> map;
        map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.forEach((integer, s) -> logger.info("key: " + integer + " value: " + s));


        try(BufferedWriter bf = new BufferedWriter(new FileWriter("test.txt"));) {
            bf.write("Cringe)");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
