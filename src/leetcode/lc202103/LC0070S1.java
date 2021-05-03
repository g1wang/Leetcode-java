package leetcode.lc202103;

/**
 * Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * Recursive(Time Limit)
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/17 16:49
 */
public class LC0070S1 {
    public int climbStairs(int n) {
        return clim(n, 1) + clim(n, 2);
    }

    public int clim(int n, int status) {
        if (status == n) return 1;
        if (status > n) return 0;
        return clim(n, status + 1) + clim(n, status + 2);

    }
}
