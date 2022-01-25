package com.leetcode.no119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/9
 * @description:
 */
public class TrangleGetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastLevel = new ArrayList<>();
        lastLevel.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 0; j <i-1; j++) {
                res.add(lastLevel.get(j)+lastLevel.get(j+1));
            }
            res.add(1);
            if(i == rowIndex){
                return res;
            }else{
                lastLevel = res;
            }
        }
        return lastLevel;
    }

    public static void main(String[] args) {
        TrangleGetRow trangleGetRow = new TrangleGetRow();
        trangleGetRow.getRow(3);
    }
}
