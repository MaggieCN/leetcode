package dfs.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/25
 * @description: 46.全排列（经典中的经典）画个树
 * https://leetcode-cn.com/problems/permutations/
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] isUsed = new boolean[len];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res,path,isUsed,nums,0);
        return res;
    }
    private void dfs(List<List<Integer>> res,
                     LinkedList<Integer> path,
                     boolean[] isUsed,
                     int[] nums,
                     int depth){
        if(depth == nums.length){
            res.add(new LinkedList<>(path)); //本道题特别注意
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]){
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(res, new LinkedList<>(path), isUsed, nums, depth+1);
                path.removeLast();
                isUsed[i] = false;
            }
        }
    }
}
