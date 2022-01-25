package com.leetcode.no15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/9/4
 * @Description
 */
public class threeNumberSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.get(0));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        for (int i = 0; i< nums.length; i++) {
            for(int j = i+1; j< nums.length; j++){
                for(int z = j+1; z< nums.length; z++) {
                    if(target == nums[i] + nums[j] + nums[z]){
                        List<Integer> result1 = new ArrayList<>();
                        result1.add(nums[i]);
                        result1.add(nums[j]);
                        result1.add(nums[z]);
                        Collections.sort(result1);
                        result.add(result1);
                    }
                }
            }
        }
        for (int i = result.size()-1; i>0; i--) {
            for (int j = i -1; j>=0; j--) {
                List<Integer> a = result.get(i);
                List<Integer> b = result.get(j);
                Boolean bool = (result.get(i)).equals(result.get(j));
                if((result.get(i)).equals(result.get(j))){
                    System.out.println("i的值:"+i+","+"j的值:"+j+","+result.get(i).get(0)+"," + result.get(i).get(1) +","+ result.get(i).get(2));
                    result.remove(i);
                    if(j!=0){
                       i--;
                       j=i;
                    }
                }
            }
        }
        return result;
    }
}
