package leetcode.lc100;

/**
 * Minimum Path Sum
 * dp
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/17 1:47
 */
public class LC0064S2 {
    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j > 0) grid[i][j] += grid[0][j - 1];
                if (j == 0 && i > 0) grid[i][j] += grid[i - 1][0];
                if (i > 0 && j > 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
