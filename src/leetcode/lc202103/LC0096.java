package leetcode.lc202103;

/**
 * Unique Binary Search Trees
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/28 21:56
 */
public class LC0096 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <=i ; j++)
                dp[i] +=dp[j-1]*dp[i-j];
        return dp[n];
    }
}
