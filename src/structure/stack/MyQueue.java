package structure.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 创建两个栈，一个用于存放元素，一个用于取出元素
 * 将存放的栈转移到取出的栈，就实现了队列的先进先出
 *
 * @Auther java_jay
 * @Date 2020/1/9
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        inToOut();
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        inToOut();
        return out.peek();
    }

    private void inToOut() {
        //当out为空时才能存入，保证顺序
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

