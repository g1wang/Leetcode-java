package leetcode.lc100;

/**
 * Search in Rotated Sorted Array
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/2 13:27
 */
public class LC0033 {
    public int search(int[] nums, int target) {

        int start = 0, end = nums.length - 1, mid = 0;
        int result = -1;
        if (nums[start] > nums[end]) {
            //find balance
            int balance = findBalance(nums, start, end);
            if (target >= nums[start]) result = searchTarget(nums, start, balance - 1, target);
            if (target <= nums[end]) result = searchTarget(nums, balance, end, target);
        } else result = searchTarget(nums, start, end, target);

        return result;
    }

    private int searchTarget(int[] nums, int start, int end, int target) {
        int mid;
        while (start < nums.length && end >= 0 && start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return -1;
    }

    private int findBalance(int[] nums, int start, int end) {
        int mid;
        int balance = -1;
        while (start < nums.length && end >= 0 && start <= end) {
            mid = (start + end) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                balance = mid;
                break;
            }
            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return balance;
    }

}
