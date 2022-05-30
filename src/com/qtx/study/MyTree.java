package com.qtx.study;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 构造层级结构（多级菜单）
 *
 * @author qtx
 * @date 2022/5/30 20:56
 */
public class MyTree {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nodes.add(new Node("名字" + i, i));
        }
        nodes.forEach(
                n -> {
                    ArrayList<Node> list = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        list.add(new Node("名字" + i + i, i * 10));
                    }
                    n.setList(list);
                });
        // System.out.println(nodes);

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Node("0" + i, "名字" + i, i));
            list.add(new Node("00" + i, "名字1" + i, i).setPid("0" + i));
            list.add(new Node("000" + i, "名字2" + i, i).setPid("00" + i));
        }
        System.out.println(list);
        // peek 的用法
        List<String> collect =
                Stream.of("one", "two", "three", "four")
                        .filter(e -> e.length() > 3)
                        .peek(e -> System.out.println("Filtered value: " + e))
                        .map(String::toUpperCase)
                        .peek(e -> System.out.println("Mapped value: " + e))
                        .collect(Collectors.toList());
        System.out.println(collect);

        List<Node> nodeList =
                list.stream()
                        .filter(f -> f.getPid() == null)
                        .peek(e -> e.setList(child(list, e)))
                        .collect(Collectors.toList());
        System.out.println(nodeList);
    }

    private static List<Node> child(List<Node> list, Node e) {
        return list.stream()
                .filter(f -> f.getPid() != null)
                .filter(f -> f.getPid().equals(e.getId()))
                .peek(p -> p.setList(child(list, p)))
                .collect(Collectors.toList());
    }
}

@Data
@Accessors(chain = true)
class Node {
    private String id;
    private String name;
    private int code;
    private String pid;

    private List<Node> list;

    public Node(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public Node(String id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
