package leetcode.lc202105;

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC190 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}
