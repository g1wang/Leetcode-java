package leetcode.lc202105;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 327. Count of Range Sum
 * https://leetcode.com/problems/count-of-range-sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/20
 */
public class LC327S2 {


    public int countRangeSum(int[] nums, int lower, int upper) {

        Map<Long, Integer> sumMap = new HashMap<>();
        sumMap.put(0l,1);
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j = lower; j <= upper; j++) {
                if (sumMap.containsKey(sum - j)) {
                    count += sumMap.get(sum - j);
                }
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;

    }
}
