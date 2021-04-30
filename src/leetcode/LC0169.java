package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0)+1;
            if (count>nums.length/2) return nums[i];
            map.put(nums[i],count);

        }
        return 0;
    }
}
