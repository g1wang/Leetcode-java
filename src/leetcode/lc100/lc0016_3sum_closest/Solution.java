package leetcode.lc100.lc0016_3sum_closest;


/*
16. 3Sum Closest
Medium

2985

167

Add to List

Share
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 Return the sum of the three integers. You may assume that each input would have e  xactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */

import java.util.Arrays;

/*
solution
参考lc0015

 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int iStart, iEnd, abs = -1, closet = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            iStart = i + 1;
            iEnd = nums.length - 1;
            while (iStart < iEnd) {
                int sum = nums[i] + nums[iStart] + nums[iEnd];
                //初始化
                if (abs < 0 || Math.abs(sum - target) < abs) {
                    abs = Math.abs(sum - target);
                    closet = sum;
                }
                if (sum < target) {
                    iStart++;
                }
                if (sum > target) {
                    iEnd--;
                }
                if (sum == target) return sum;
            }
        }
        return closet;
    }
}
