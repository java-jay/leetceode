package structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 155. 最小栈
 *
 * @Auther java_jay
 * @Date 2020/1/9
 */
public class MinStack {
    private List<Integer> data;
    private List<Integer> mins;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<Integer>();
        //存放元素在data中对应的索引
        mins = new ArrayList<Integer>();
    }

    /**
     * 同时存入元素，minStack存放的永远是最小值（会存放重复的值）
     *
     * @param x
     */
    public void push(int x) throws Exception {
        data.add(x);
        if (mins.size() == 0) {
            mins.add(0);
        } else {
            int min = getMin();
            if (x < min) {
                mins.add(data.size() - 1);
            }
        }
    }

    /**
     * 同时取出元素，重置最小值
     */
    public void pop() throws Exception {
        if (data.size() == 0) {
            throw new Exception("栈为空");
        }
        int popIndex = data.size() - 1;
        int minIndex = mins.get(mins.size() - 1);
        if (popIndex == minIndex) {
            mins.remove(mins.size() - 1);
        }
        data.remove(data.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() throws Exception {
        if (data.size() == 0) {
            throw new Exception("栈为空");
        }
        int minIndex = mins.get(mins.size() - 1);
        return data.get(minIndex);
    }
}
