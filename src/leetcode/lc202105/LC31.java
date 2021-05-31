package leetcode.lc202105;

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/31
 */
public class LC31 {
    public void nextPermutation(int[] nums) {
        // 1,4,5,3,2 : 532是最大的组合，需前一位数做组合
        //从后向前(已经是降序的)找第一个大于4的数交换，再从432 组合最小的，reverse: 234
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);


    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
