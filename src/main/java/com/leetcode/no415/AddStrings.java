package com.leetcode.no415;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description:
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int nums11 = 0;
        int nums22 = 0;
        for (int i = 0; i <num1.length() ; i++) {
            nums11 +=Math.pow(10,num1.length() -1-i) * (num1.charAt(i) - '0');
        }
        for (int i = 0; i <num2.length() ; i++) {
            nums22 +=Math.pow(10,num2.length() -1-i) * (num2.charAt(i) - '0');
        }
        int res = nums11 + nums22;
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        addStrings.addStrings("6913259244",
                "71103343");
    }
}
