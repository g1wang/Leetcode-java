package leetcode.lc202105;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/11
 */
public class LC581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = -1;
        int end = -2;
        int max = nums[0], min = nums[n - 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) end = i;
            else max = nums[i];
            if (nums[n - i - 1] > min) start = n - i - 1;
            else min =nums[n-i-1];
        }
        return end - start + 1;
    }
}
