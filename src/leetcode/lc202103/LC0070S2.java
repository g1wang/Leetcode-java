package leetcode.lc202103;

/**
 * Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 *     dp
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/17 16:58
 */
public class LC0070S2 {
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
}
