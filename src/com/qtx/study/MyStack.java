package com.qtx.study;

import org.testng.annotations.Test;

/**
 * @author qtx
 */
public class MyStack {
    public static void main(String[] args) {}

    /** 数组 */
    @Test
    public void test() {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1).push(2).push(3).push(4).push(5);
        System.out.println(stack.show());
        System.out.println(stack.pop());
        System.out.println(stack.show());
    }

    @Test
    public void test1() {
        LinkedStack stack = new LinkedStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.show());
        System.out.println(stack.pop());
        System.out.println(stack.show());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(10);
        System.out.println(stack.show());
    }
}

/** 数组模拟栈 */
class ArrayStack {
    private final int[] stack;
    private final int maxSize;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public ArrayStack push(int value) {
        if (isFull()) {
            return this;
        }
        stack[++top] = value;
        return this;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack[top--];
    }

    public String show() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = top; i >= 0; i--) {
            builder.append(stack[i]);
            if (i != 0) {
                builder.append(",");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}

/** 单链表模拟栈 */
class LinkedStack {
    private final int maxSize;
    private int num;
    private Node one;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }
    }

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return num == maxSize;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈以满");
        }
        Node temp = one;
        one = new Node(value);
        one.next = temp;
        num++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈以空");
        }
        Node temp = one;
        one = temp.next;
        num--;
        return temp.value;
    }

    public String show() {
        if (isEmpty()) {
            throw new RuntimeException("栈以空");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Node temp = one;
        while (temp != null) {
            int value = temp.value;
            builder.append(value);
            if (temp.next != null) {
                builder.append(",");
            }
            temp = temp.next;
        }
        builder.append("}");
        return builder.toString();
    }
}
