package leetcode.lc300;

/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/
 */
public class LC0238 {
    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count++;
            if (count > 1) {
                p = 0;
                break;
            }
            if (nums[i] != 0) p *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (count > 1) {
                nums[i] = 0;
            }
            if (count == 1) {
                if (nums[i] == 0) nums[i] = p;
                else nums[i] = 0;
            }
            if (count == 0) {
                nums[i] = p/nums[i];
            }
        }
        return nums;
    }

}
