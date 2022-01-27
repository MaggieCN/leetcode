package dfs.permutations;

/**
 * @author: gaomeiqi
 * @Date: 2022/1/25
 * @description:
 */
public class MainLC {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int[] nums = {1,1,2};
        LC77 lc77 = new LC77();
        lc77.combine(4,2);
        LC90 lc90 = new LC90();
        lc90.subsetsWithDup(nums);
        /*
        //LC46
        LC46 lc46 = new LC46();
        lc46.permute(nums);
         */

        /*
        //LC47
        LC47 lc47 = new LC47();
        lc47.permuteUnique(nums);
         */

    }
}
