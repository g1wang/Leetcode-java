package leetcode.lc202105;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/4
 */
public class LC0300 {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] countArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if (nums[j] < nums[i]) {
                    countArr[i] = Math.max(countArr[j]+1,countArr[i]);
                }
            }
            countArr[i] = Math.max(countArr[i],1);
            max = Math.max(countArr[i], max);
        }
        return max;
    }

}
