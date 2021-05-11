package leetcode.lc202105;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * <p>
 * Runtime: 6 ms, faster than 93.34% of Java online submissions for Partition Equal Subset Sum.
 * Memory Usage: 39.3 MB, less than 69.58% of Java online submissions for Partition Equal Subset Sum
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC416S3 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int k = sum >> 1;
        boolean[][] memo = new boolean[n][k + 1];
        Arrays.sort(nums);
        return dfs(nums, n - 1, k, memo);
    }

    boolean dfs(int[] nums, int idx, int k, boolean[][] memo) {
        if (k == 0) return true;
        if (idx < 0 || k < 0) return false;
        if (memo[idx][k]) return false;
        boolean result = dfs(nums, idx - 1, k - nums[idx], memo);
        if (result) return true;
        memo[idx][k] = true;
        return dfs(nums, idx - 1, k, memo);

    }
}
