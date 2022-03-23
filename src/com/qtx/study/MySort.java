package com.qtx.study;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * @author qtx
 */
public class MySort {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public void bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void bubbleSortingTest() {
        int[] ints = {-3, -2, 10, 5, 1, 8, 9, -1};
        bubbleSorting(ints);
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            double v = Math.random() * 10000;
            arr[i] = (int) v;
        }
        Instant start = Instant.now();
        bubbleSorting(arr);
        Instant end = Instant.now();
        System.out.println("共耗时：" + Duration.between(start, end).toMillis() + " 毫秒");
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public void selectSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int current = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    current = j;
                }
            }
            if (current == i) {
                continue;
            }
            arr[current] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectSortingTest() {
        int[] ints = {9, 5, 7, 8};
        selectSorting(ints);
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            double v = Math.random() * 10000;
            arr[i] = (int) v;
        }
        Instant start = Instant.now();
        selectSorting(arr);
        Instant end = Instant.now();
        System.out.println("共耗时：" + Duration.between(start, end).toMillis() + " 毫秒");
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public int[] insertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }

    @Test
    public void insertSortingTest() {
        int[] ints = {9, 5, 7, 8};
        int[] ints1 = insertSorting(ints);
        System.out.println(Arrays.toString(ints1));
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            double v = Math.random() * 10000;
            arr[i] = (int) v;
        }
        Instant start = Instant.now();
        int[] sorting = insertSorting(arr);
        Instant end = Instant.now();
        System.out.println("共耗时：" + Duration.between(start, end).toMillis() + " 毫秒");
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public int[] donaldShell(int[] arr) {
        for (int x = arr.length / 2; x > 0; x /= 2) {
            for (int i = x; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && temp < arr[j - x]) {
                    arr[j] = arr[j - x];
                    j--;
                }
                if (i != j) {
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    public void donaldShellTest() {
        int[] ints = {9, 5, 7, 8};
        int[] ints1 = donaldShell(ints);
        System.out.println(Arrays.toString(ints1));
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            double v = Math.random() * 10000;
            arr[i] = (int) v;
        }
        Instant start = Instant.now();
        int[] sorting = donaldShell(arr);
        Instant end = Instant.now();
        System.out.println("共耗时：" + Duration.between(start, end).toMillis() + " 毫秒");
    }
}
