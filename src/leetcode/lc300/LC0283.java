package leetcode.lc300;

/*
283. Move Zeroes
https://leetcode.com/problems/move-zeroes/
 */
public class LC0283 {
    public void moveZeroes(int[] nums) {
        int nzIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[nzIndex] = nums[i];
            nzIndex++;
        }
        for (int i = nzIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
