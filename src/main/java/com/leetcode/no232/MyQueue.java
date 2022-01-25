package com.leetcode.no232;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    public MyQueue() {

    }

    public void push(int x) {
        list1.addLast(x);
    }

    public int pop() {
        list2.addLast(list1.removeFirst());
        return list2.removeLast();
    }

    public int peek() {
        int tmp = list1.removeFirst();
        list2.addFirst(tmp);
        list1.addFirst(tmp);
        return list2.removeFirst();
    }

    public boolean empty() {
        if(list2.isEmpty())
            return true;
        return false;
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}


