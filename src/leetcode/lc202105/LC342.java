package leetcode.lc202105;

/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/19
 */
public class LC342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && Math.log10(n) / Math.log10(4) % 1 == 0;
    }
}
