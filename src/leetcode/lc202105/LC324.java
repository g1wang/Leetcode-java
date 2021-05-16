package leetcode.lc202105;

/**
 * 324. Wiggle Sort II]
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC324 {

    public void wiggleSort(int[] nums) {
        if (nums.length == 1) return;
        int n = nums.length;
        int mid = quickSelect(nums, 0, n - 1, (n + 1) / 2);
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[getIndex(j, n)] > mid)
                swap(nums, getIndex(i++, n), getIndex(j++, n));
            else if (nums[getIndex(j, n)] < mid)
                swap(nums, getIndex(j, n), getIndex(k--, n));
            else
                j++;
        }
    }

    int getIndex(int i, int n) {
        return (1 + 2 * (i)) % (n | 1);
    }

    int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        swap(nums, start, end);
        int left = start;
        for (int i = start; i <= end; i++) {
            if (pivot > nums[i]) {
                swap(nums, left, i);
                left++;
            }
        }
        swap(nums, left, end);
        if (left == k) return nums[k];
        else if (left > k) {
            return quickSelect(nums, start, left - 1, k);
        } else return quickSelect(nums, left + 1, end, k);

    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
