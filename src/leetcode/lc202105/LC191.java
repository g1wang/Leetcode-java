package leetcode.lc202105;

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC191 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n>>=1;
        }
        return count;
    }
}
