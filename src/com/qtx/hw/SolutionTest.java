package com.qtx.hw;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: QTX
 * @Date: 2022/2/16
 */
public class SolutionTest {


    /**
     * 进制转换
     *
     * @param s 被转换16进制
     *
     * @return 转换10进制
     */
    public int base(String s) {
        if (s == null) {
            return -1;
        }
        int num = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') {
                num = num * 16 + s.charAt(i) - 55;
            } else {
                num = num * 16 + s.charAt(i) - '0';
            }
        }
        return num;
    }

    @Test
    public void testBase() {
        System.out.println(base("0xE0FE"));
    }

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> num = new HashSet<>();
        String s;
        while ((s = br.readLine()) != null) {
            num.add(s);
        }
        Set<String> sortSet = new TreeSet<>(Comparator.naturalOrder());
        sortSet.addAll(num);
        sortSet.forEach(System.out::println);

        Integer.parseInt("123");

    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] qj = s.split(" ");
            Arrays.sort(qj, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1.split(",")[0]) - Integer.parseInt(o2.split(",")[0]);
                }
            });
            Stack<String> stringStack = new Stack();
            stringStack.push(qj[0]);
            for (int i = 0; i < qj.length - 1; i++) {
                StringBuilder newQP = new StringBuilder();
                String qji = stringStack.pop();
                String qjj = qj[i + 1];
                String[] strings1 = qji.split(",");
                String[] strings2 = qjj.split(",");
                if (Integer.parseInt(String.valueOf(strings1[1])) >= Integer.parseInt(String.valueOf(strings2[0]))) {
                    if (Integer.parseInt(String.valueOf(strings1[1])) <= Integer.parseInt(String.valueOf(strings2[1]))) {
                        newQP.append(strings1[0]).append(",").append(strings2[1]);
                        stringStack.push(newQP.toString());
                    } else {
                        stringStack.push(qji);
                    }
                } else {
                    stringStack.push(qji);
                    stringStack.push(qjj);
                }
            }
            StringBuilder pnewQP = new StringBuilder();
            while (!stringStack.empty()) {
                String pop = stringStack.pop();
                pnewQP.insert(0, pop + " ");
            }
            System.out.println(pnewQP);
        }
    }


    /**
     * 两数之和
     *
     * @param arr    数组
     * @param target 目标求和
     */
    public int[] sum(int[] arr, int target) {
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>(length / 3 * 4);
        for (int i = 0; i < arr.length; i++) {
            int x = target - arr[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x) + 1, i + 1};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    @Test
    public void sumTest() {
        System.out.println(Arrays.toString(sum(new int[]{3, 4, 1, 9}, 12)));
    }


}
