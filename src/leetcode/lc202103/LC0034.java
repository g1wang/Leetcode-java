package leetcode.lc202103;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/2 16:08
 */
public class LC0034 {
    public int[] searchRange(int[] nums, int target) {

        int p;
        p = searchTarget(nums, target);
        int s = p, e = p;
        while (s - 1 >= 0 && nums[s - 1] == target) s--;
        while (e >= 0 && e + 1 < nums.length && nums[e + 1] == target) e++;
        return new int[]{s, e};

    }

    private int searchTarget(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length, mid;
        while (start < nums.length && end >= 0 && start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return -1;
    }
}
