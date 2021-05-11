package leetcode.lc202105;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * <p>
 * Runtime: 4 ms, faster than 98.46% of Java online submissions for Partition Equal Subset Sum.
 * Memory Usage: 39.6 MB, less than 56.73% of Java online submissions for Partition Equal Subset Sum.
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC416S2 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int k = sum >> 1;
        boolean[][] memo = new boolean[n][k];
        Arrays.sort(nums);
        return sum(nums, 0, k, 0, memo);
    }

    boolean sum(int[] nums, int idx, int k, int sum, boolean[][] memo) {
        if (idx == nums.length||sum > k) return false;
        if (sum == k) return true;
        if (memo[idx][sum]) return false;
        boolean result = sum(nums, idx + 1, k, sum + nums[idx], memo);
        if (result) return true;
        memo[idx][sum] = true;
        return sum(nums, idx + 1, k, sum, memo);
    }
}
