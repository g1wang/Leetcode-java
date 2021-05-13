package leetcode.lc202105;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                ans+= map.getOrDefault(-(num3 + num4), 0);
            }
        }
        return ans;
    }
}
