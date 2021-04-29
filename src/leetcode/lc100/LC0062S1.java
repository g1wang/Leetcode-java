package leetcode.lc100;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Paths
 * https://leetcode.com/problems/unique-paths/
 *  Recursive (Time limit exceed )
 * @author CodeX
 * @version 1.0
 * @date 2021/4/16 21:37
 */
public class LC0062S1 {

    public int uniquePaths(int m, int n) {
        return go(1, 1, m, n);

    }

    public int go(int x, int y, int m, int n) {
        if (x == m && y == n) {
            return 1;
        }
        if (x < m && y < n) {
            return go(x + 1, y, m, n) + go(x, y + 1, m, n);
        } else if (x < m) {
            return go(x + 1, y, m, n);
        } else return go(x, y + 1, m, n);
    }
}
