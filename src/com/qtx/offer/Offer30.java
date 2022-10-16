package com.qtx.offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * <P>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。</P>
 *
 * @author qtx
 * @since 2022/10/16 20:47
 */
public class Offer30 {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(-2);
        queue.push(0);
        queue.push(-1);
        System.out.println(queue);
        System.out.println(queue.min());
        System.out.println(queue.top());
        queue.pop();
        System.out.println(queue);
        System.out.println(queue.min());
        System.out.println(queue.top());
    }

    static class Queue {

        private final Stack<Integer> stack;

        private final Stack<Integer> min;

        public Queue() {
            this.stack = new Stack<>();
            this.min = new Stack<>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            min.push(Math.min(min.peek(), x));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }

        @Override
        public String toString() {
            return "Queue{" + "stack=" + stack + ", min=" + min + '}';
        }
    }
}
