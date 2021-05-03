package leetcode.lc202103;

import java.util.*;

/*
18. 4Sum
Medium

3075

403

Add to List

Share
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [], target = 0
Output: []


Constraints:

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class LC0018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> sets = new HashSet<>();
        List<Integer> list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int iTarget = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int iStart = j + 1, iEnd = nums.length - 1;
                while (iStart < iEnd) {
                    int sum = nums[j] + nums[iStart] + nums[iEnd];
                    if (sum < iTarget) iStart++;
                    if (sum > iTarget) iEnd--;
                    if (sum == iTarget) {
                        list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[iStart]);
                        list.add(nums[iEnd]);
                        sets.add(list);
                        iStart++;
                        iEnd--;
                    }
                }
            }

        }
        return new ArrayList<>(sets);

    }

    public static void main(String[] args) {
        fourSum(new int[]{0, 0, 0, 0}, 0);
    }
}
