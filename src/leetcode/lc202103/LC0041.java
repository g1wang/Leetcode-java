package leetcode.lc202103;

/**
 * First Missing Positive
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/6 11:20
 */
public class LC0041 {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        firstMissingPositive(nums);
    }
}
