package leetcode.lc202105;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *  Runtime: 859 ms, faster than 24.17% of Java online submissions for Subarray Sum Equals K.
 *  Memory Usage: 42 MB, less than 30.93% of Java online submissions for Subarray Sum Equals K.
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/11
 */
public class LC560 {

    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=nums[i];
            if(sum==k) count++;
            for (int j = i + 1; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k) count++;
            }
        }
        return count;
    }
}
