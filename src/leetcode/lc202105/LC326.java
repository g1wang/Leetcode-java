package leetcode.lc202105;

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 *
 * 换底公式
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC326 {

    public boolean isPowerOfThree(int n) {
        return (Math.log10(n)/Math.log10(3))%1==0;

    }
}
