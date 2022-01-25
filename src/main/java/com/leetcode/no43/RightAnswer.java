package com.leetcode.no43;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/14
 * @description:
 * https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
 */
public class RightAnswer {
    public static void main(String[] args) {
        RightAnswer rightAnswer = new RightAnswer();
        System.out.println(rightAnswer.multiply("123", "456"));
    }
    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() -1; i >=0 ; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = num2.length() -1; j >=0 ; j--) {
                int n = num2.charAt(j) - '0';
                int sum = m*n + res[i+j+1];
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            if(i == 0 && res[i] == 0) continue;
            buffer.append(res[i]);
        }
        return buffer.toString();
    }
}
