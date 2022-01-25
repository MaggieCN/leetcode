package com.leetcode.no77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author MaggieCN
 * @Date 2021/11/9
 * @Description
 */
public class Combine {
    /* 未剪枝
    public static void main(String[] args) {
        int n = 4, k=2;
        combine(n,k);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfsCombine(result, new LinkedList<>(), 0, n, k);
        return result;
    }
    public static void dfsCombine(List<List<Integer>> result,
                                  LinkedList<Integer> path,
                                  int depth,
                                  int n,
                                  int k){
        if(depth == k){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = 1; i<= n; i++){
            if(path.size() == 0){
                path.add(i);
                dfsCombine(result, path, depth + 1, n, k);
                path.removeLast();
            }else{
                if(i > path.get(path.size()-1)){
                    path.add(i);
                    dfsCombine(result, path, depth + 1, n, k);
                    path.removeLast();
                }
            }
        }
    }

     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res, path, 1, n, k, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, LinkedList<Integer> path, int start, int n, int k, int depth){
        if(depth == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <=n ; i++) {
            path.add(i);
            dfs(res, path, i+1, n, k, depth+1);
            path.removeLast();
        }
    }
}
