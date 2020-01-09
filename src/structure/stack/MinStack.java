package structure.stack;

import java.util.Stack;

/**
 * @Auther java_jay
 * @Date 2020/1/9
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /**
     * 同时存入元素，minStack存放的永远是最小值（会存放重复的值）
     * @param x
     */
    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    /**
     * 同时取出元素，重置最小值
     */
    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
