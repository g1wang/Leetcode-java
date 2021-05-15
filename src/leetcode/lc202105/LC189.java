package leetcode.lc202105;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC189 {
    public void rotate(int[] nums, int k) {
        int start=0, len=0,nextIdx=start;
        k%=nums.length;
        if (k==0) return;
        while (len<nums.length){
            int tmp = nums[start];
            nextIdx = (nextIdx+k)%nums.length;
            nums[start]=nums[nextIdx];
            nums[nextIdx]=tmp;
            if (nextIdx==start) {
                start++;
                nextIdx=start;
            }
            len++;
        }
    }
}
