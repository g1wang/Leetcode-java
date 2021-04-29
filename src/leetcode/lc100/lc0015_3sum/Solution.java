package leetcode.lc100.lc0015_3sum;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
 */


import java.util.*;

/*
solution
1 sort
2 two pointers
3 two loop

 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> sets = new HashSet<>();
        Arrays.sort(nums);
        int iStart, iEnd;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            iStart = i + 1;
            iEnd = nums.length - 1;
            while (iStart < iEnd && nums[i] <= 0) {
                int sum = nums[i] + nums[iStart] + nums[iEnd];
                if (sum < 0) {
                    iStart++;
                }
                if (sum > 0) {
                    iEnd--;
                }
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[iStart]);
                    list.add(nums[iEnd]);
                    sets.add(list);
                    iStart++;
                    iEnd--;
                }
            }
        }
        return new ArrayList<>(sets);
    }

}
