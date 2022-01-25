package com.leetcode.no2;

import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/16
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        int[] list1 = {2,4,3};
        int[] list2 = {5,6,4};
        Test test = new Test();
        System.out.println(test.addTwoNumbers(list1, list2));
    }
    public int[] addTwoNumbers(int[] l1, int[] l2) {
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        int cur1 = 0;
        int cur2 = 0;
        while (cur1 < l1.length || cur2 < l2.length) {
            int m1 = cur1 < l1.length ? l1[cur1] : 0;
            int m2 = cur2 < l2.length ? l2[cur2] : 0;
            cur1++;
            cur2++;
            buffer1.append(m1);
            buffer2.append(m2);
        }
        char[] c1 = buffer1.reverse().toString().toCharArray();
        char[] c2 = buffer2.reverse().toString().toCharArray();
        int add = 0;
        int index = c1.length - 1;
        StringBuffer resultBuffer = new StringBuffer();
        while(index >=0 || add!=0){
            int a = index >=0 ? c1[index] - '0' : 0;
            int b = index >=0 ? c2[index] - '0' : 0;
            int result = a+b + add;
            resultBuffer.append(result % 10);
            add = result / 10;
            index --;
        }
        char[] result_char = resultBuffer.toString().toCharArray();
        int[] resultInt = new int[result_char.length];
        for (int i = 0; i < resultInt.length; i++) {
            resultInt[i] = result_char[i] -'0';
            System.out.println(resultInt[i]);
        }
        return resultInt;
    }
}
