package leetcode.lc202105;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/10
 */
public class LC739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        labebl:
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    continue labebl;
                }
            }
            ans[i] = 0;
        }
        ans[T.length - 1] = 0;
        return ans;
    }

}
