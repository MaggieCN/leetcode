package testAnnual.Solution20211113;

/**
 * @Author MaggieCN
 * @Date 2021/11/13
 * @Description
 * 快排
 */
public class SolutionFastSort20211113 {
    public static void main(String[] args) {
        int[] nums = {5,3,2,1};
        sortArray(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
        // 5 , 3 , 2 , 1
        //left 0 right 3
        //
    }
    public static int[] sortArray(int nums[]){
        int left = 0;
        int right = nums.length -1;
        quickSort(nums, left, right);
        return nums;
    }
    public static void quickSort(int nums[], int left, int right){
        if(left < right){
            int mid = partition(nums, left, right);
            quickSort(nums,left, mid -1);
            quickSort(nums, mid +1, right);
        }
    }
    //
    public static int partition(int nums[], int left, int right){
        int pivot = nums[left];
        int index = left;
        for (int i = index + 1; i <= right ; i++) {
            if(pivot > nums[i]){
                index ++;
                swap(nums, index, i);
            }
        }
        swap(nums, index, left);
        return index;
    }
    public static void swap(int nums[], int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
