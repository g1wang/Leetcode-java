package leetcode;


/*
31. Next Permutation
Medium

5230

1790

Add to List

Share
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

import java.util.Arrays;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/1 13:42
 */
public class LC0031 {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        //反向找下降点
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //反向找比下降点大的点，也就是第一个比下降点大的点
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //因为是降序的，也可直接交换
        //Arrays.sort(nums, i + 1, nums.length);
        reserve(nums, i + 1, nums.length - 1);
    }

    void reserve(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;

        }

    }

    void swap(int nums[], int i, int j) {
        int a = nums[j];
        nums[j] = nums[i];
        nums[i] = a;
    }
}
