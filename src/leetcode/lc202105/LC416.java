package leetcode.lc202105;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Time Limit Exceeded
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int k = sum >> 1;
        Arrays.sort(nums);
        return sum(nums, nums.length - 1, k, 0);
    }

    boolean sum(int[] nums, int idx, int k, int sum) {
        if (idx == -1 || sum > k) return false;
        if (sum  == k) return true;
        return sum(nums, idx - 1, k, sum + nums[idx]) || sum(nums, idx - 1, k, sum);
    }
}
