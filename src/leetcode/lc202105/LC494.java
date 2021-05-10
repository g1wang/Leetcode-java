package leetcode.lc202105;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/7
 */
public class LC494 {
    int memo;

    public int findTargetSumWays(int[] nums, int target) {
        find(nums, target, 0, 0);
        return memo;
    }

    void find(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (target == sum) memo++;
            return;
        }
        find(nums, target, i + 1, sum + nums[i]);
        find(nums, target, i + 1, sum - nums[i]);
    }
}
