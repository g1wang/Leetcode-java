package leetcode;

/**
 * Maximum Subarray
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/8 16:20
 */
public class LC0053 {
    public int maxSubArray(int[] nums) {

        int sum = nums[0], max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum : 0;
            sum += nums[i];
            max = max > sum ? max : sum;
        }
        return max;

    }

}
