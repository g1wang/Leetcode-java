package bwc.biweekly_contest_53;

import java.util.*;

//5757. Get Biggest Three Rhombus Sums in a Grid
public class Pro3 {
    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                set.add(grid[i][j]);
                int len = 1;
                while (true) {
                    if (i - len < 0 || j - len < 0 || i + len >= grid.length || j + len >= grid[0].length) break;
                    int sum = grid[i][j - len] + grid[i - len][j] + grid[i + len][j] + grid[i][j + len];
                    for (int k = 1; k < len; k++) {
                        sum += grid[i - k][j - len + k] + grid[i - k][j + len - k] + grid[i + k][j - len + k] + grid[i + k][j + len - k];
                    }
                    set.add(sum);
                    len++;
                }
            }
        }
        List<Integer> list = new ArrayList();
        for (Integer integer : set) {
            list.add(integer);
        }
        Collections.sort(list);
        int[] ans;
        if (list.size() > 3) {
            ans = new int[]{list.get(list.size() - 1), list.get(list.size() - 2), list.get(list.size() - 3)};
        } else {
            ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(list.size() - 1 - i);
            }
        }
        return ans;
    }


}
