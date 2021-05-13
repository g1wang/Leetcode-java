package leetcode.lc202105;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. Binary Subarrays With Sum
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC930 {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int dp[] = new int[nums.length+1];
        int ans =0 ,sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            sum+=num;
            if (map.containsKey(sum-goal)){
                ans+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
