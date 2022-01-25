package com.leetcode.no17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/7
 * @Description
 */
public class LetterCombination {
    public static void main(String[] args) {
        String a = "23";
        List<String> res = letterCombinations(a);
        for (String re : res) {
            System.out.println(re);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(result, new StringBuilder(), digits, 0, digits.length(), map);
        return result;
    }
    public static void dfs(List<String> result,
                           StringBuilder path,
                           String digits,
                           int depth,
                           int len,
                           HashMap map){
        if(depth == len){
            result.add(path.toString());
            return;
        }
        Character c = digits.charAt(depth);
        String cur = map.get(c).toString();
        for (int i = 0; i < cur.length(); i++) {
            path.append(cur.charAt(i));
            dfs(result,path,digits,depth+1, len, map);
            path.deleteCharAt(path.length()-1);
        }
    }
}

