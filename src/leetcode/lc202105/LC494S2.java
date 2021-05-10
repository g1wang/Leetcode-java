package leetcode.lc202105;

import java.util.Arrays;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/7
 */
public class LC494S2 {

    public int findTargetSumWays(int[] nums, int target) {
        int[][] memos = new int[nums.length][2001];
        for (int[] memo : memos) {
            Arrays.fill(memo,Integer.MIN_VALUE);
        }

        return find(nums, target, 0, 0,memos);
    }

    int find(int[] nums, int target, int i, int sum, int[][] memos) {
        if (i == nums.length) {
            if (target == sum) return 1;
            return 0;
        }
        if (memos[i][sum+1000]!=Integer.MIN_VALUE){
            return memos[i][sum+1000];
        }
        int add = find(nums, target, i + 1, sum + nums[i], memos);
        int sub = find(nums, target, i + 1, sum - nums[i], memos);
        memos[i][sum+1000] = add+sub;
        return memos[i][sum+1000];
    }
}
