package com.leetcode.no232;

import java.util.ArrayDeque;
import java.util.Deque;

public class RightAnswer {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        System.out.println(deque.peek());
        System.out.println(deque.pop());
        System.out.println(deque.isEmpty());
    }
}
