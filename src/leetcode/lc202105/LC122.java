package leetcode.lc202105;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
