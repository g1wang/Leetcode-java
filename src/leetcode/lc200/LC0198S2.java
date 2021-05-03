package leetcode.lc200;

/**
 * 198. House Robber
 * greey
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/1
 */
public class LC0198S2 {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int memoFur=0,memoClose=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int cur = Math.max(nums[i]+memoFur,memoClose);
            memoFur = memoClose;
            memoClose = cur;
        }
        return memoClose;
    }
}
