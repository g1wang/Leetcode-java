package leetcode.lc202104;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0128 {
    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            int count;
            if ((count =map.getOrDefault(nums[i],0)+1)>0){
                map.put(nums[i]+1,count);
                max =Math.max(count,max);
            }

        }
        return max;

    }
}
