package ua.univer.DemoApp;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 7, 8, 7 , 66, 32};
        System.out.println(Arrays.toString(arr));
        var myPool = new ForkJoinPool(4);
        myPool.invoke(new MergeSortTask(arr));
        System.out.println(Arrays.toString(arr));
    }
}
