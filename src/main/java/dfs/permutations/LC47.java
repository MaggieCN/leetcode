package dfs.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/25
 * @description: 全排列（不重复的）
 * https://leetcode-cn.com/problems/permutations-ii/
 * 题解：https://leetcode-cn.com/problems/permutations-ii/solution/47-quan-pai-lie-iiche-di-li-jie-pai-lie-zhong-de-q/
 * 对 isUsed[i-1] = false 和 true 的区别讲的特别清楚
 * isUsed false : 数层剪枝，前一个已经被用过（因为已经排序过了），所以剪枝更彻底（效率更高）。
 *        true : 树枝剪枝，经常会找不到叶子节点，产生很多分支，效率低。
 */
public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
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
            //判断isUsed[i-1] false 说明刚刚已经用过了，但是remove掉了。
            if(i !=0 && nums[i] == nums[i-1] && !isUsed[i-1]) continue;
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
