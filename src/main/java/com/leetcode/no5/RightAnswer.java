package com.leetcode.no5;

import java.util.Random;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/15
 * @description:
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * 动态规划：
 * 回文天然具有「状态转移」性质：一个长度严格大于 2 的回文去掉头尾字符以后，剩下的部分依然是回文。
 * 反之，如果一个字符串头尾两个字符都不相等，那么这个字符串一定不是回文。
 * 第 1 步：定义状态
 * dp[i][j] 表示：子串 s[i..j] 是否为回文子串，这里子串 s[i..j] 定义为左闭右闭区间，即可以取到 s[i] 和 s[j]。
 * 第 2 步：思考状态转移方程
 * 根据头尾字符是否相等，需要分类讨论：
 * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
 * 说明：
 * 「动态规划」的「自底向上」求解问题的思路，很多时候是在填写一张二维表格。
 * 由于 s[i..j] 表示 s 的一个子串，因此 i 和 j 的关系是 i <= j，只需要填这张表格对角线以上的部分；
 * 看到 dp[i + 1][j - 1] 就需要考虑特殊情况：
 * 如果去掉 s[i..j] 头尾两个字符子串 s[i + 1..j - 1] 的长度严格小于 2（不构成区间），
 * 即 j - 1 - (i + 1) + 1 < 2时，整理得 j - i < 3
 * 此时 s[i..j] 是否是回文只取决于 s[i] 与 s[j] 是否相等。
 * 结论也比较直观：j - i < 3 等价于 j - i + 1 < 4
 * 即当子串 s[i..j]s[i..j] 的长度等于 2 或者等于 3 的时候，s[i..j] 是否是回文由 s[i] 与 s[j] 是否相等决定。
 *
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RightAnswer {
    public static void main(String[] args) {
        String s = "cbbd";
        RightAnswer rightAnswer = new RightAnswer();
        System.out.println(rightAnswer.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        char[] s_char = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int max = 1;
        for (int j = 0; j <s.length() ; j++) {
             for (int i = 0; i <=j ; i++) {
                if(s_char[i] == s_char[j]){
                    if(j-i<3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j]&& j-i+1>max){
                    begin = i;
                    max = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
