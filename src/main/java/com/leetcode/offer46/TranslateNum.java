package com.leetcode.offer46;

/**
 * @Author MaggieCN
 * @Date 2021/10/21
 * @Description
 *
 */
public class TranslateNum {
    public static void main(String[] args) {
        int num = 12258;
        System.out.println(translateNum(num));
    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] result = new int[s.length()+1];
        result[0] = 1;
        for (int i = 1; i <result.length ; i++) {
            result[i] = result[i-1];
            if(i >1){
                int tmp = (s.charAt(i-2)-'0')*10 + s.charAt(i-1) - '0';
                if(tmp >=10 && tmp <=25){
                    result[i]+= result[i-2];
                }
            }
        }
        return result[s.length()];
    }
}
