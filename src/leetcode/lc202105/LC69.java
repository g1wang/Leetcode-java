package leetcode.lc202105;

import java.util.Map;

/**
 *
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC69 {

    public int mySqrt(int x) {
        if (x < 2) return x;
        //return (int) Math.sqrt(x);
        int i = 1, j = x - 1, mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (mid > x / mid) {
                j = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                i = mid + 1;
            }
        }
        return i;
    }
}
