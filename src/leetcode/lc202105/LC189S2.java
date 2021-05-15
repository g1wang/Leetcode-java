package leetcode.lc202105;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC189S2 {
    public void rotate(int[] nums, int k) {

        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
