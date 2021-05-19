package leetcode.lc202105;

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/19
 */
public class LC231S2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
