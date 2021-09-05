package leetcode.lc2109;

/*
34. Find First and Last Position of Element in Sorted Array
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {

        int pos = findTarget(nums, target);
        if (pos == -1) return new int[]{-1, -1};
        else {
            int left = findLeft(nums, 0, pos, target);
            int right = findRight(nums, pos, nums.length - 1, target);
            return new int[]{left, right};
        }
    }

    private int findLeft(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target && mid - 1 >= 0 && nums[mid - 1] < target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }

    private int findRight(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target && mid + 1 < nums.length && nums[mid + 1] > target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return nums.length - 1;
    }

    private int findTarget(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;

        }
        return -1;
    }
}
