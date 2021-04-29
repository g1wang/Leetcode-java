package leetcode.lc100;

/**
 * Jump Game
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/9 19:04
 */
public class LC0055 {
    public boolean canJump(int[] nums) {
        int curStepEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length && i <= curStepEnd; i++) {
            if (i + nums[i] >= nums.length - 1) return true;
            farthest = Math.max(i + nums[i], farthest);
            if (i == curStepEnd) {
                curStepEnd = farthest;
            }
        }
        return false;

    }
}
