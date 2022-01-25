package com.leetcode.no387;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author MaggieCN
 * @Date 2021/11/29
 * @Description
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
 */
public class RightAnswer {
    public static void main(String[] args) {
        String s = "loaeleetcode";
        firstUniqChar2(s);
    }
    /**
     * 方法一：使用哈希表存储频数
     * 对字符串进行两次遍历。
     * 在第一次遍历时，使用哈希映射统计出字符串中每个字符出现的次数。
     * 在第二次遍历时，只出现一次的字符，那么就返回它的索引，否则在遍历结束后返回 -1。
     *
     */
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
           // map.put(s.charAt(i),map.get(s.charAt(i)) ==null?  1: map.get(s.charAt(i))+1);
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
    /**
     * 方法二：使用哈希表存储索引
     * 键表示一个字符，值表示它的首次出现的索引
     * 第一次遍历字符串时，设当前遍历到的字符为 c
     * 如果 c不在哈希映射中，c与它的索引作为一个键值对加入哈希映射中，
     * 否则将 c在哈希映射中对应的值修改为 -1。
     * 第二次遍历哈希映射中的所有值，找出其中不为 -1的最小值，即为第一个不重复字符的索引。
     */
    public static int firstUniqChar2(String s) {
        if(s.length() == 0) return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            Character ch = s.charAt(i);
            if(map.get(ch) == null){
                map.put(ch,i);
            }else {
                map.put(ch,-1);
            }
        }
        int first = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == s.length()) {
            first = -1;
        }
        return first;
        /**
        int res;
        for (int i = 0; i < map.size() ; i++) {
            if(map.get(i) !=-1) return
        }
        return -1;
         */
    }
    /**
     * 方法三：队列
     * 思路与算法
     * 与方法二相同的哈希映射，并且使用一个额外的队列
     * 按照顺序存储每一个字符以及它们第一次出现的位置。
     * 当我们对字符串进行遍历时，设当前遍历到的字符为 c，
     * 如果 c 不在哈希映射中，将 c 与它的索引作为一个二元组放入队尾，
     * 否则我们就需要检查队列中的元素是否都满足「只出现一次」的要求，
     * 即我们不断地根据哈希映射中存储的值（是否为 -1）选择弹出队首的元素，
     * 直到队首元素「真的」只出现了一次或者队列为空。
     * 在遍历完成后，如果队列为空，说明没有不重复的字符，返回 −1，
     * 否则队首的元素即为第一个不重复的字符以及其索引的二元组。
     *
     * 小贴士
     * 在维护队列时，我们使用了「延迟删除」这一技巧。
     * 也就是说，即使队列中有一些字符出现了超过一次，
     * 但它只要不位于队首，那么就不会对答案造成影响，我们也就可以不用去删除它。
     * 只有当它前面的所有字符被移出队列，它成为队首时，我们才需要将它移除。
     *
     */
    public int firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
