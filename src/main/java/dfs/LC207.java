package dfs;

import java.util.LinkedList;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/21
 * @description:
 */
public class LC207 {
    public static void main(String[] args) {
        LC207 lc207 = new LC207();
        lc207.canFinish(3, new int[][]
        {{0,1},{0,2},{1,2}});
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <prerequisites.length ; i++) {
            for (int j = 0; j <2 ; j++) {
                int pre = prerequisites[i][1];
                int pro = prerequisites[i][0];
                if(pre == pro) return false;
                if (list.contains(pre) && list.contains(pro)){
                    if (list.indexOf(pre) > list.indexOf(pro)) return false;
                }else if(list.contains(pre)){
                    list.add(list.indexOf(pre)+1,pro);
                }else if(list.contains(pro)){
                    if(list.indexOf(pro) == 0){
                        list.addFirst(pre);
                    }else{
                        list.add(list.indexOf(pro),pre);
                    }
                }else{
                    list.addLast(pre);
                    list.addLast(pro);
                }
            }
        }
        return true;
    }
}
