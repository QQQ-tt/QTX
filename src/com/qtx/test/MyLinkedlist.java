package com.qtx.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author qtx
 */
public class MyLinkedlist {
    public static void main(String[] args) {
        Person person = new Person("小红", "上海");
        Person person1 = new Person("小黑", "北京");
        Person person2 = new Person("小白", "深圳");
        Person person3 = new Person("小紫", "广州");

        List<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person1);
        people.add(person2);
        people.add(person3);

        SingleLinkedList<Person> linkedList = new SingleLinkedList<>(people);
        linkedList.showList();

    }
}

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
    }
}

class SingleLinkedList<E> {
    private static class Node<E> {
        int no;
        E object;
        Node<E> next;

        public Node() {
        }

        public Node(int no, E obj) {
            this.no = no;
            this.object = obj;
        }
    }

    private final Node<E> heroNode;

    public SingleLinkedList() {
        heroNode = new Node<>();
    }

    public SingleLinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    public void add(Node<E> h) {
        Node<E> temp = heroNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = h;
    }

    public void addAll(Collection<? extends E> collection) {
        int i = 0;
        for (E e : collection) {
            add(new Node<E>(i, e));
            i++;
        }
    }

    public void showList() {
        Node<E> temp = heroNode;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println("no:" + temp.no + ",name:" + temp.object);
        }
    }
}