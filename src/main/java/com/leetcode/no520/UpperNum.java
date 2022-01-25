package com.leetcode.no520;

/**
 * @Author MaggieCN
 * @Date 2021/11/15
 * @Description
 */
public class UpperNum {
    public boolean detectCapitalUse(String word) {
        Character first = word.charAt(0);
        if(Character.isLowerCase(first)){
            for (int i = 1; i <word.length() ; i++) {
                if(!Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        }else{
            Character second = word.charAt(1);
            if(Character.isLowerCase(second)){
                for (int i = 2; i <word.length() ; i++) {
                    if(!Character.isLowerCase(word.charAt(i)))
                        return false;
                }
            }else{
                for (int i = 2; i <word.length() ; i++) {
                    if(Character.isLowerCase(word.charAt(i)))
                        return false;
                }
            }
        }
        return true;
    }
}
