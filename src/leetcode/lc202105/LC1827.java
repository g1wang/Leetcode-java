package leetcode.lc202105;

/**
 * 1827. Minimum Operations to Make the Array Increasing
 * greedy
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/22
 */
public class LC1827 {
    public int minOperations(int[] nums) {
        int opts = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff <= 0) {
                opts -= diff - 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return opts;

    }
}
