package com.leetcode.no43;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 */
public class Multiply {
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.multiply("123","456");
    }
    public String multiply(String num1, String num2) {
        List<StringBuffer> list = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int add = 0;
        int multiple = 0;
        int index = 0;
        for (int i = len2; i >=0 ; i--) {
            for (int j = len1; j >=0 ; j--) {
                int m = num1.charAt(j) - '0';
                int n = num2.charAt(i) - '0';
                int cur = m*n + add;
                add = m*n/10;
                buffer.append(cur%10);
            }
            list.add(buffer);
            buffer = new StringBuffer();
            buffer.append('0');
        }
        buffer.reverse();
        return buffer.toString();
    }
}
