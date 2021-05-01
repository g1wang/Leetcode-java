package leetcode;

/**
 * 198. House Robber
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/1
 */
public class LC0198 {
    public int rob(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (i < 2)
                ans = Math.max(ans, dp[i]);
        }
        for (int i = 2; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                max = Math.max(max, dp[i] + dp[j]);
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }
}
