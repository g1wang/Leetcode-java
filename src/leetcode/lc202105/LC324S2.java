package leetcode.lc202105;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II]
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC324S2 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2 - 1;
        if ((n % 2) == 1) {
            mid = n / 2;
        }
        int end = n - 1;
        int[] cpNums = Arrays.copyOf(nums, n);
        for (int i = 0, j = mid; i < n; i += 2, j--, end--) {
            nums[i] = cpNums[j];
            if (i < n - 1) nums[i + 1] = cpNums[end];
        }
    }
}
