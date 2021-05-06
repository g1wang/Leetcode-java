package leetcode.lc202105;

import java.util.*;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * 10ms
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/6
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for(int i = coin; i <= amount; i++){
                if(i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
