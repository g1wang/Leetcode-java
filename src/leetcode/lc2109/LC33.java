package leetcode.lc2109;

public class LC33 {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        if (nums[start] > nums[end]) {
            //findPart
            int pivot = findPart(nums, start, end);
            if (nums[start] == target) return start;
            if (nums[start] < target) return tsearch(start, pivot - 1, nums, target);
            else return tsearch(pivot, end, nums, target);
        } else return tsearch(start, end, nums, target);


    }

    private int findPart(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = (end + start) / 2;
            if (mid - 1 >= 0 && nums[mid-1] > nums[mid]) return mid;
            else if (nums[0] > nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    private int tsearch(int start, int end, int[] nums, int target) {
        while (start < nums.length && end >= 0 && start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC33 lc33 = new LC33();
        System.out.println(lc33.search(new int[]{1}, 2));
    }
}
