package leetcode.lc200;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29
 */
public class LC0121 {
    public int maxProfit(int[] prices) {
        int max=prices[0],min=prices[0];
        int maxProfit=0;
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i]<min) {
                min = prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i]-min);
        }
        return maxProfit;

    }
}
