package com.leetcode.no20;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IsValidCharacter {
    public static void main(String[] args) {
        String s ="((";
        isValid(s);
    }
    public static boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length() ; i++) {
            Character c = s.charAt(i);
            if (list.isEmpty()){
                list.addFirst(c);
            }else{
                Character m = list.removeLast();
                if(m == '(' && c == ')') continue;
                else if(m == '[' && c == ']') continue;
                else if(m == '{' && c == '}') continue;
                else {
                    list.addLast(m);
                    list.addLast(c);
                }
            }
        }
        if(list.isEmpty()){
            return true;
        }
        return false;
    }
}
