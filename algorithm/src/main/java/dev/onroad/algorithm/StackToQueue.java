package dev.onroad.algorithm;

import java.util.Stack;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-08 01:01
 * @description 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 */
public class StackToQueue {
    private Stack<Integer> topStack;
    private Stack<Integer> tailStack;
    private int front;
    /**
     * Initialize your data structure here.
     */
    public StackToQueue() {
        topStack = new Stack<>();
        tailStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (topStack.empty())
            front = x;
        while (!topStack.isEmpty())
            tailStack.push(topStack.pop());
        tailStack.push(x);
        while (!tailStack.isEmpty())
            topStack.push(tailStack.pop());

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        if (!topStack.isEmpty()) {
            return topStack.pop();
        }
        return 0;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!topStack.isEmpty()) {
            return topStack.peek();
        }
        return 0;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return topStack.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        System.out.println(stackToQueue.peek());
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.empty());
    }
}
