package com.leetcode.no415;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/13
 * @description:
 * https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/
 */
public class RIghtAnswer {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
    public String addStrings1(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int add = 0;
        StringBuffer buffer = new StringBuffer();
        while(len1>=0 || len2 >=0 || add!=0){
            int x = len1 >=0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >=0 ? num2.charAt(len2) - '0' : 0;
            int result = x + y + add;
            buffer.append(result%10);
            add = result/10;
            len1--;
            len2--;
        }
        buffer.reverse();
        return buffer.toString();
    }
}
