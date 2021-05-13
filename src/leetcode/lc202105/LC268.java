package leetcode.lc202105;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        int n= nums.length;
        return n-(sum-(n-1)*n/2);

    }
}
