package com.leetcode.no520;

/**
 * @Author MaggieCN
 * @Date 2021/11/15
 * @Description
 *  链接：https://leetcode-cn.com/problems/detect-capital/solution/jian-ce-da-xie-zi-mu-by-leetcode-solutio-449z/
 * 0    1
 * 小写 大写 错误
 *  0    1
 * 小写 小写
 * 大写 大写
 * 大写 小写
 * 以上三种情况，那么从2开始的字符跟1字符大小写相同就行
 * 异或(^) 两者相等为0,不等为1
 */
public class RightAnswer {
    public boolean detectCapitalUse(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}
