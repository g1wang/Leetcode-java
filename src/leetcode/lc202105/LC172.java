package leetcode.lc202105;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n>0){
            ans+=n/5;
            n/=5;
        }
        return ans;
    }
}
