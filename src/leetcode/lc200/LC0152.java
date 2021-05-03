package leetcode.lc200;

/**
 * 152. Maximum Product Subarray
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/1
 */
public class LC0152 {
    public int maxProduct(int[] nums) {

        int n = nums.length + 1;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <nums.length ; i++) {
            dp[i][i] = nums[i];
            max =Math.max(max,nums[i]);
        }
        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = nums[j]*dp[i][j-1];
                max =Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

}
