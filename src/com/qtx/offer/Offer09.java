package com.qtx.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1
 * )</p>
 *
 * @author qtx
 * @since 2022/10/16 20:17
 */
public class Offer09 {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.addItem(2);
        queue.addItem(7);
        System.out.println(queue);
        System.out.println(queue.deleteItem());
        System.out.println(queue);
        queue.addItem(66);
        System.out.println(queue);
    }

    static class Queue {
        private final Deque<Integer> in;
        private final Deque<Integer> out;

        public Queue() {
            this.in = new ArrayDeque<>();
            this.out = new ArrayDeque<>();
        }

        public void addItem(int item) {
            in.push(item);
        }

        public String deleteItem() {
            if (out.isEmpty()) {
                if (in.isEmpty()) {
                    return "数据为空";
                }
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop() + "";
        }

        @Override
        public String toString() {
            return "Queue{" + "in=" + in + ", out=" + out + '}';
        }
    }
}
