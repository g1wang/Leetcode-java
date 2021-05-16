package leetcode.lc202105;

/**
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * <p>
 * two pointers
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/17
 */
public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE, peek = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= low) low = num;
            else if (num <= peek) peek = num;
            else return true;
        }
        return false;
    }
}
