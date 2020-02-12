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


    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }


    public void push(int x) {
        in.push(x);
    }


    public int pop() {
        inToOut();
        return out.pop();
    }


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

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

