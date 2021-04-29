package leetcode.lc100;

/**
 * Sort Colors
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/17 21:28
 */
public class LC0075 {
    public void sortColors(int[] nums) {
        //O(nlogn)
        //Arrays.sort(nums);

        //O(n)
        int end = nums.length - 1;
        int start = 0;
        int i = 0;
        while (start < end && i <= end) {
            if (nums[i] == 0) {
                nums[start] = 0;
                if (i > start) {
                    nums[i] = 1;
                }
                start++;
                i++;
                continue;
            }
            if (nums[i] == 1) {
                i++;
                continue;
            }
            if (nums[i] == 2) {
                int tmp = nums[end];
                nums[i] = tmp;
                nums[end] = 2;
                end--;
            }

        }


    }
}

