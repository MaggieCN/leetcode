package testAnnual.Solution20211113;

import java.util.*;

/**
 * @author: gaomeiqi
 * @Date: 2022/2/7
 * @description:
 */
public class SolutionDfsSecond {
    public int numIslands(char[][] grid) {
        int amount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsIslands(grid, i, j);
                    amount++;
                }
            }
        }
        return amount;
    }

    public void dfsIslands(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if (grid[row][col] != '1') return;
        grid[row][col] = '2';
        dfsIslands(grid, row + 1, col);
        dfsIslands(grid, row - 1, col);
        dfsIslands(grid, row, col + 1);
        dfsIslands(grid, row, col - 1);
    }

    public int islandPerimeter(int[][] grid) {
        int length = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    length = dfsIslandLength(grid, i, j);
            }
        }
        return length;
    }

    public int dfsIslandLength(int[][] grid, int row, int col) {
        if (row == -1 || col == -1 || row == grid.length || col == grid[0].length) return 1;
        if (grid[row][col] == 0) return 1;
        if (grid[row][col] == 2) return 0;
        grid[row][col] = 2;
        return dfsIslandLength(grid, row + 1, col) + dfsIslandLength(grid, row, col + 1)
                + dfsIslandLength(grid, row - 1, col) + dfsIslandLength(grid, row, col - 1);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] isUsed = new boolean[nums.length];
        dfs(res, path, isUsed, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res,
                    LinkedList<Integer> path,
                    boolean[] isUsed,
                    int[] nums,
                    int depth
    ) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(res, path, isUsed, nums, depth + 1);
                isUsed[i] = false;
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        dfsUnique(res, path, isUsed, nums, 0);
        return res;
    }

    public void dfsUnique(List<List<Integer>> res,
                          LinkedList<Integer> path,
                          boolean[] isUsed,
                          int[] nums,
                          int depth
    ) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) continue;
            if (!isUsed[i]) {
                path.add(nums[i]);
                isUsed[i] = true;
                dfsUnique(res, path, isUsed, nums, depth + 1);
                isUsed[i] = false;
                path.removeLast();
            }
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfsSubset(res, path, nums, 0);
        return res;
    }

    public void dfsSubset(List<List<Integer>> res,
                          LinkedList<Integer> path,
                          int[] nums,
                          int begin
    ) {
        res.add(new ArrayList<>(path));
        if (path.size() == nums.length) return;
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfsSubset(res, path, nums, i + 1);
            path.removeLast();
        }
    }

    /*
    给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        dfsSubsetDup(res, path, nums, 0, 0);
        return res;
    }

    public void dfsSubsetDup(List<List<Integer>> res,
                             LinkedList<Integer> path,
                             int[] nums,
                             int depth,
                             int begin) {
        res.add(new ArrayList<>(path));
        if (path.size() == nums.length) return;
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfsSubsetDup(res, path, nums, depth + 1, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfsCombinationSum(res, path, candidates, 0, target);
        return res;
    }

    public void dfsCombinationSum(List<List<Integer>> res,
                                  LinkedList<Integer> path,
                                  int[] nums,
                                  int begin,
                                  int target) {
        for (int i = begin; i < nums.length; i++) {
            if (target - nums[i] < 0) return;
            else if (target - nums[i] > 0) {
                path.add(nums[i]);
                dfsCombinationSum(res, path, nums, i, target - nums[i]);
            } else {
                path.add(nums[i]);
                res.add(new ArrayList<>(path));
            }
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfsCombinationSum2(res, path, candidates, 0, target);
        return res;
    }

    public void dfsCombinationSum2(List<List<Integer>> res,
                                   LinkedList<Integer> path,
                                   int[] nums,
                                   int begin,
                                   int target) {
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) continue;
            if (target - nums[i] < 0) return;
            else if (target - nums[i] > 0) {
                path.add(nums[i]);
                dfsCombinationSum2(res, path, nums, i + 1, target - nums[i]);
            } else {
                path.add(nums[i]);
                res.add(new ArrayList<>(path));
            }
            path.removeLast();
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        HashMap<Character, List<String>> map = new HashMap<>();
        for (int i = 2; i < 10; i++) {
            int cur = (i - 2) * 3;
            map.put('i', Arrays.asList("a" + cur, "b" + cur, "c" + cur));
        }

        return res;
    }

    public void dfsLetter(List<String> res,
                          StringBuffer buffer,
                          HashMap<Character, List<String>> map,
                          String digits,
                          int begin) {
        for (int i = begin; i < digits.length(); i++) {
            Character c = digits.charAt(i);
            List<String> list = map.get(c);
            list.get(0);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsMaxArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfsMaxArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if (grid[row][col] != 1) return 0;
        grid[row][col] = 2;
        return 1 + dfsMaxArea(grid, row + 1, col) + dfsMaxArea(grid, row - 1, col)
         + dfsMaxArea(grid, row, col + 1) + dfsMaxArea(grid, row, col - 1);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        Deque<Integer> path;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            path = new ArrayDeque<>();
            path.add(nums[i]);
            if(set.contains(nums[i])) break;
            dfsSubsequence(res, path, nums, i, i + 1);
            set.add(nums[i]);
        }
        return res;
    }

    public void dfsSubsequence(List<List<Integer>> res,
                               Deque<Integer> path,
                               int[] nums,
                               int maxIndex,
                               int begin){
        for (int i = begin; i < nums.length ; i++) {
            if(nums[maxIndex] <= nums[i]){
                path.add(nums[i]);
                int prev = maxIndex;
                maxIndex = i;
                res.add(new ArrayList<>(path));
                dfsSubsequence(res,path, nums, maxIndex, i + 1);
                path.removeLast();
                maxIndex = prev;
            }
        }
    }
    public static void main(String[] args) {
        SolutionDfsSecond solutionDfsSecond = new SolutionDfsSecond();
        int[] nums = {1,0,1,1,1};
        solutionDfsSecond.findSubsequences(nums);
    }

}
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        Deque<Integer> path;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            path = new ArrayDeque<>();
            path.add(nums[i]);
            if(set.contains(nums[i])) break;
            dfsSubsequence(res, path, nums, i, i + 1);
            set.add(nums[i]);
        }
        return res;
    }

    public void dfsSubsequence(List<List<Integer>> res,
                               Deque<Integer> path,
                               int[] nums,
                               int maxIndex,
                               int begin){
        for (int i = begin; i < nums.length ; i++) {
            if(nums[maxIndex] <= nums[i]){
                path.add(nums[i]);
                maxIndex = i;
                res.add(new ArrayList<>(path));
                dfsSubsequence(res,path, nums, maxIndex, i + 1);
                path.removeLast();
            }
        }
    }
}