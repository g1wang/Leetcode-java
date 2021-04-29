package leetcode.lc100;

/**
 * Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * <p>
 * Dynamic programming
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/16 23:36
 */
public class LC0062S2 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0||j == 0) dp[i][j] = 1;
                if (i != 0 && j != 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
