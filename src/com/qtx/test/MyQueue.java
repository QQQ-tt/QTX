package com.qtx.test;


/**
 * @author qtx
 */
public class MyQueue {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
        queueArray.show();
        queueArray.add(1);
        queueArray.show();
        System.out.println(queueArray.get());
        System.out.println(queueArray.get());
        queueArray.show();
        queueArray.add(2);
        queueArray.add(3);
        queueArray.show();
        System.out.println(queueArray.showTail());
        System.out.println(queueArray.showHead());
    }
}


/**
 * 一次性队列
 */
class QueueArray {
    private final int[] arr;
    private final int size;
    private int tail;
    private int head;

    /**
     * 创建队列并设置长度
     *
     * @param size 队列长度
     */
    public QueueArray(int size) {
        this.size = size;
        arr = new int[size];
        this.tail = -1;
        this.head = -1;
    }

    /**
     * 展示队列
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空。");
        } else {
            for (int i = head + 1; i < tail + 1; i++) {
                System.out.printf("arr[%d] = %d \n", i, arr[i]);
            }
        }
    }

    /**
     * 添加数字
     *
     * @param i 整形数字
     *
     * @return
     */
    public boolean add(int i) {
        if (isFull()) {
            System.out.println("队列已满。");
            return false;
        }
        arr[++tail] = i;
        return true;
    }

    /**
     * 获取队列头部并删除
     *
     * @return
     */
    public int get() {
        if (isEmpty()) {
            System.out.println("队列为空。");
            return -1;
        }
        return arr[++head];
    }

    /**
     * 展示队列头部
     *
     * @return
     */
    public int showHead() {
        if (isEmpty()) {
            System.out.println("队列为空。");
            return -1;
        }
        return arr[head + 1];
    }

    /**
     * 展示队列尾部
     *
     * @return
     */
    public int showTail() {
        if (isEmpty()) {
            System.out.println("队列为空。");
            return -1;
        }
        return arr[tail];
    }

    private boolean isFull() {
        return this.tail + 1 == size;
    }

    private boolean isEmpty() {
        return this.tail == this.head;
    }
}

/**
 * 循环队列
 */
class CycleQueueArray {
    private int[] arr;
    private int tail;
    private int head;
    private int size;

    public CycleQueueArray(int size) {
        this.size = size;
        arr = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    public boolean add(int i) {
        return true;
    }

    /**
     * 判断队列是否为空
     *
     * @return true为空, 反之为非空
     */
    private boolean isEmpty() {
        return this.head == this.tail;
    }


    private boolean isFull() {
        return true;
    }
}
