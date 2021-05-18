package leetcode.lc202105;

import java.util.Arrays;

/**
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC329 {

    public static void main(String[] args) {
        LC329 lc329 = new LC329();
        lc329.longestIncreasingPath(new int[][]{{1, 2}});
    }

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] == 0) {
                    max = Math.max(max, dfs(dp, matrix, dp[i][j], i, j, true));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] dp, int[][] matrix, int pre, int i, int j, boolean isFirst) {

        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        int cur = matrix[i][j];
        if (!isFirst && cur <= pre) {
            return 0;
        }
        if (dp[i][j] > 0) return dp[i][j];
        int r1 = dfs(dp, matrix, cur, i - 1, j, false);
        int r2 = dfs(dp, matrix, cur, i + 1, j, false);
        int r3 = dfs(dp, matrix, cur, i, j - 1, false);
        int r4 = dfs(dp, matrix, cur, i, j + 1, false);
        int subMax = Math.max(Math.max(r1, r2), Math.max(r3, r4));
        dp[i][j] += subMax+1;
        return dp[i][j];
    }
}
