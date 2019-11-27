package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValid {
    private HashMap<Character, Character> map;

    public IsValid() {
        map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        //建立栈
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果当前字符是右括号
            if (map.containsKey(c)) {
                //如果栈中已无元素，就赋值一个#，如果有元素，就弹出栈首元素
                char topElement = stack.empty() ? '#' : stack.pop();
                //如果栈首元素不是左括号
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                //如果当前字符不是右括号，就将左括号存入栈中
                stack.push(c);
            }
        }
        //如果栈中为空，就为true
        return stack.isEmpty();
    }
}
