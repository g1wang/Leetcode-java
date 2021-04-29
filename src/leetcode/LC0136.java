package leetcode;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29 21:03
 */
public class LC0136 {

    public int singleNumber(int[] nums) {

        int e= nums.length-1;
        for (int i = 0; i < nums.length/2+1; i++) {
            boolean match = false;
            for (int j = nums.length-1; j >i ; j--) {
                if (nums[i]==nums[j]){
                    swap(nums,j,e);
                    e--;
                    match = true;
                    break;
                }
            }
            if (!match) return nums[i];
        }
        return nums[nums.length/2];


    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
