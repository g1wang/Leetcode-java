package leetcode.lc100;

/**
 * Jump Game II
 * Greedy
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/8 18:13
 */
public class LC0045 {
    public int jump(int[] nums) {
        int curStepEnd = 0, step = 0, farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == curStepEnd) {
                step++;
                curStepEnd = farthest;
            }
        }
        return step;
    }


}
