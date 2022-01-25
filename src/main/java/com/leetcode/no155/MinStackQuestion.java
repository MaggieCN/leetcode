package com.leetcode.no155;

import java.util.Stack;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/23
 * @description:
 */
public class MinStackQuestion {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(1);
        obj.push(3);
        obj.push(-2);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
    }
}
class MinStack {
    private Stack<Integer> stack;
    public MinStack() {
        this.stack= new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(stack.size() == 0) return -1;
        int min = stack.get(0);
        for (int i = 1; i < stack.size(); i++) {
            min = Math.min(min,stack.get(i));
        }
        return min;
    }
}