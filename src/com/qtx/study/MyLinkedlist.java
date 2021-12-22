package com.qtx.study;

import org.junit.Test;

import java.util.Collection;

/**
 * @author qtx
 */
public class MyLinkedlist {
    private final Num num1 = new Num(1);
    private final Num num2 = new Num(2);
    private final Num num3 = new Num(3);
    private final Num num4 = new Num(4);

    public static void main(String[] args) {
        Person person = new Person("小红", "上海");
        Person person1 = new Person("小黑", "北京");
        Person person2 = new Person("小白", "深圳");
        Person person3 = new Person("小紫", "广州");

        /*List<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person1);
        people.add(person2);
        people.add(person3);

        SingleLinkedList<Person> linkedList = new SingleLinkedList<>(people);
        linkedList.showList();*/

        SingleLinkedList<Person> list = new SingleLinkedList<>();

        list.add(person1);
        list.add(person2);
        list.addHead(person);
        System.out.println("size:" + list.size());
        list.showList();
        System.out.println(list.getNode(4));
        System.out.println(list.getReciprocalNode(1));
        list.deleteTail();
        list.showList();
        list.deleteHead();
        list.showList();
        list.add(person);
        list.add(person2);
        list.add(person3);
        System.out.println("------------");
        list.deleteTail().deleteTail().deleteTail();
        list.showList();
        System.out.println("逆转");
        SingleLinkedList<Person> reverse = list.singlelistReverse();
        reverse.showList();

    }

    @Test
    public void test() {
        SingleLinkedList<Num> list = new SingleLinkedList<>();
        list.circularAdd(num1).circularAdd(num2).circularAdd(num3).circularAdd(num4);
        list.showList();
    }

    @Test
    public void test1() {
        DoubleLinkedList<Num> list = new DoubleLinkedList<>();
        list.add(num1).add(num2).add(num3).add(num4);
        list.show();
        System.out.println("--------------");
        list.delete(4);
        list.show();
    }
}

/**
 * 实体类
 */
class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
    }
}

/**
 * 实体类
 */
class Num {
    private int i;

    public Num(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Num{" + "i=" + i + '}';
    }
}

/**
 * 单链表
 */
class SingleLinkedList<E> {
    private final Node<E> heroNode;

    public SingleLinkedList() {
        heroNode = new Node<>();
    }

    /**
     * 将List集合转换成单链表
     *
     * @param collection list集合
     */
    public SingleLinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * 向链表添加数据
     *
     * @param node 数据对象
     */
    public void add(E node) {
        Node<E> temp = heroNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(node);
    }

    /**
     * 向链表头添加元素
     *
     * @param node 元素
     */
    public void addHead(E node) {
        Node<E> temp = heroNode.next;
        heroNode.next = new Node<>(node);
        heroNode.next.next = temp;
    }

    /**
     * 将集合转换成链表
     *
     * @param collection 被转换集合
     */
    private void addAll(Collection<? extends E> collection) {
        collection.forEach(this::add);
    }

    /**
     * 打印输出链表内容，需要实现toString()方法
     */
    public void showList() {
        Node<E> temp = heroNode;
        while (temp.next != null) {
            temp = temp.next;
            if (temp == heroNode) {
                break;
            }
            System.out.println("obj:" + temp.object);
        }
    }

    /**
     * 获得链表长度
     *
     * @return 链表实际长度
     */
    public int size() {
        if (heroNode.next == null) {
            return 0;
        }
        Node<E> temp = heroNode;
        for (int i = 0; ; i++) {
            if (temp.next == null || temp.next == heroNode) {
                return i;
            }
            temp = temp.next;
        }
    }

    /**
     * 获取链表第N个元素
     *
     * @param num 具体位置
     *
     * @return 元素本事
     */
    public E getNode(int num) {
        if (size() == 0 || size() < num) {
            return null;
        }
        Node<E> temp = heroNode;
        for (int i = 0; i < num + 1; i++) {
            if (i == num) {
                break;
            }
            temp = temp.next;
        }
        return temp.object;
    }

    /**
     * 获取链表倒数第N个元素
     *
     * @param num 具体位置
     *
     * @return 元素本事
     */
    public E getReciprocalNode(int num) {
        return getNode(size() - num + 1);
    }

    /**
     * 删除最新添加的元素
     */
    public SingleLinkedList<E> deleteTail() {
        if (size() == 0) {
            return null;
        }
        Node<E> temp = heroNode;
        while (true) {
            if (temp.next.next == null || temp.next.next == heroNode) {
                if (temp.next.next == null) {
                    temp.next = null;
                    break;
                } else {
                    temp.next = heroNode;
                    break;
                }
            }
            temp = temp.next;
        }
        return this;
    }

    /**
     * 删除指定位置的节点
     *
     * @param num
     */
    public void delete(int num) {
        Node<E> temp = heroNode;

    }

    /**
     * 删掉链表的第一个节点
     *
     * @return 如果成功返回true, 否则返回false.
     */
    public boolean deleteHead() {
        if (size() == 0) {
            return false;
        }
        if (size() > 1) {
            heroNode.next = heroNode.next.next;
        } else {
            heroNode.next = null;
        }
        return true;
    }

    /**
     * 单链表逆转
     *
     * @return 被逆转过的单链表
     */
    public SingleLinkedList<E> singlelistReverse() {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return this;
        }
        Node<E> temp = heroNode;
        SingleLinkedList<E> linkedList = new SingleLinkedList<>();
        while (temp.next != null) {
            temp = temp.next;
            linkedList.addHead(temp.object);
        }
        return linkedList;
    }

    /**
     * 单链表合并,要求泛型相同
     *
     * @param list1 单链表1
     * @param list2 单链表2
     *
     * @return 合并后的单链表
     */
    public SingleLinkedList<E> linkedMerge(SingleLinkedList<E> list1, SingleLinkedList<E> list2) {
        //todo

        return null;
    }

    /**
     * 单链表排序
     */
    public void sort() {
        //todo

    }

    /**
     * 环形链表添加
     *
     * @param obj 节点
     */
    public SingleLinkedList<E> circularAdd(E obj) {
        Node<E> temp = heroNode;
        while (temp.next != null) {
            if (temp.next == heroNode) {
                break;
            }
            temp = temp.next;
        }
        Node<E> node = new Node<>(obj);
        temp.next = node;
        node.next = heroNode;
        return this;
    }

    /**
     * 节点
     *
     * @param <E> 节点内容指定对象类型
     */
    private static class Node<E> {
        E object;
        Node<E> next;

        public Node() {
        }

        public Node(E obj) {
            this.object = obj;
        }
    }
}

/**
 * 双链表
 *
 * @param <E> 指定对象类型
 */
class DoubleLinkedList<E> {
    private final Node<E> one;

    public DoubleLinkedList() {
        this.one = new Node<>();
    }

    /**
     * 添加数据
     *
     * @param obj 添加到此列的数据
     *
     * @return 链式调用
     */
    public DoubleLinkedList<E> add(E obj) {
        Node<E> temp = one;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<E> next = new Node<>(obj);
        temp.next = next;
        next.pre = temp;
        return this;
    }

    /**
     * 删除指定位置节点
     *
     * @return 链式调用
     */
    public DoubleLinkedList<E> delete(int i) {
        Node<E> temp = one;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        //自我删除,temp被删除的节点
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
        temp.pre.next = temp.next;
        return this;
    }

    /**
     * 展示链表内容(需要重写toString()方法)
     */
    public void show() {
        if (one.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node<E> temp = one.next;
        while (temp != null) {
            System.out.println(temp.object);
            temp = temp.next;
        }
    }

    /**
     * 节点内部类
     *
     * @param <E>
     */
    private static class Node<E> {
        E object;
        Node<E> next;
        Node<E> pre;

        public Node(E object) {
            this.object = object;
        }

        public Node() {
        }
    }
}