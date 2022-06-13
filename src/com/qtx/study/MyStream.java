package com.qtx.study;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qtx
 * @date 2022/5/3 23:04
 */
public class MyStream {

    private static final int NUM = 100;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < NUM; i++) {
            list.add(i);
        }

        list.stream()
                .filter(integer -> integer < 50)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        Person1 p1 = new Person1();
        p1.setAddress("黑龙江");
        p1.setName("小钱");
        Person1Vo person1Vo = Optional.of(p1).map(Person1Vo::new).orElse(new Person1Vo());
        System.out.println(person1Vo);
    }

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>(10);
        List<String> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            map.put("key:" + i, "val:" + i);
            list.add("key:" + i);
            list.add("key:" + i * 2);
        }
        System.out.println(Arrays.toString(list.toArray()));
        list.forEach(
                l -> {
                    boolean b = map.containsKey(l) ? strings.add(map.get(l)) : strings.add("null");
                });
        strings.forEach(System.out::println);
    }
}

@Data
class Person1 {
    private String name;
    private String address;
}

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
class Person1Vo extends Person1 {

    private String age;
    private Person1 person1;

    public Person1Vo(Person1 person1) {
        this.person1 = person1;
    }
}
