package dfs.permutations;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/27
 * @description: 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res =  new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int count = 0;
        if(n==1) {
            path.add(1);
            res.add(path);
            return res;
        }
        for (int i = 1; i <= n ; i++) {
            path.add(i);
            count++;
            for (int j = i; j <= n; j++) {
                path.add(j);
                count++;
                if(count == k){
                    res.add(new LinkedList<>(path));
                    path = new LinkedList<>();
                    if(j!=n){
                        path.add(i);
                        count = 1;
                    }else{
                        count = 0;
                    }
                }
            }
        }
        return  res;
    }
}
