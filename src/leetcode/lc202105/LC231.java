package leetcode.lc202105;

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/19
 */
public class LC231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Math.log10(n)/Math.log10(2) % 1 == 0;
    }
}
