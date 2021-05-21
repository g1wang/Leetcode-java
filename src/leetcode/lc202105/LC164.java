package leetcode.lc202105;

import java.util.Arrays;
import java.util.List;

/**
 * 164. Maximum Gap
 * https://leetcode.com/problems/maximum-gap/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/21
 */
public class LC164 {
    public int maximumGap(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        //每个区间分担的值
        int gapSize = (int) Math.ceil((double) (max - min + 1) / nums.length);
        int[] bucketMax = new int[nums.length];
        int[] bucketMin = new int[nums.length];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int num : nums) {
            //每个区间只需要取最大最小，不需要所有的值
            int idx = (num - min) / gapSize;
            bucketMax[idx] = Math.max(num, bucketMax[idx]);
            bucketMin[idx] = Math.min(num, bucketMin[idx]);
        }
        int pre = min, ans = 0;
        for (int i = 0; i < bucketMax.length; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) continue;
            ans = Math.max(ans, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        return ans;

    }
}
