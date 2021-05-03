package leetcode.lc202105;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CodeX
 * @version 1.0
 * @date 2021/5/4
 */
public class LC0207 {
/*
    1
   / \
  2   3
 / \
 4 5
/
1
 */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> undo = new HashSet<>();
        boolean[] finish = new boolean[numCourses];
        int[][] grid = new int[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            grid[pre[0]][pre[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(grid, undo, i, finish)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] grid, Set<Integer> undo, int cur, boolean[] finish) {
        undo.add(cur);
        for (int i = 0; i < grid.length; i++) {
            if (undo.contains(i)) return false;
            if (grid[cur][i] != 1) continue;
            if (finish[i]) continue;
            undo.add(i);
            if (!dfs(grid, undo, i, finish)) return false;
            undo.remove(i);
        }
        finish[cur] = true;
        undo.remove(cur);
        return true;
    }
}
