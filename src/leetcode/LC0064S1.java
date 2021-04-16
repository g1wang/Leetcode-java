package leetcode;

import java.util.*;

/**
 * Minimum Path Sum
 * Recursive
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/17 0:26
 */
public class LC0064S1 {
    public int minPathSum(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        helper(grid, 0, 0, sum, list);
        Collections.sort(list);
        return list.get(0);
    }

    public void helper(int[][] grid, int x, int y, int sum, List<Integer> list) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            sum += grid[x][y];
            list.add(sum);
            return;
        }
        if (x < grid.length - 1) {
            helper(grid, x + 1, y, sum + grid[x][y], list);
        }
        if (y < grid[0].length - 1) {
            helper(grid, x, y + 1, sum + grid[x][y], list);
        }
    }
}
