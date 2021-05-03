package leetcode.lc202104;

/*
239. Sliding Window Maximum
 */
public class LC0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        len = len <= 0 ? 1 : len;
        int[] ans = new int[len];
        int maxIndex = -1;
        for (int i = 0; i < len; i++) {
            if (maxIndex < i) {
                maxIndex = findMax(nums, i, i + k - 1);
            }else {
                if (nums[maxIndex]<=nums[i+k-1]){
                    maxIndex = i+k-1;
                }
            }
            ans[i]=nums[maxIndex];
        }
        return ans;

    }

    int findMax(int[] nums, int start, int end) {
        if (end >= nums.length) end = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
