package leetcode.lc200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0128S2 {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        while (!set.isEmpty()){
            int num = set.iterator().next();
            int low = 0;
            while (set.contains(num - low-1)) {
                set.remove(num-low-1);
                low++;
            }
            int high=0;
            while (set.contains(num + high+1)) {
                set.remove(num+high+1);
                high++;
            }
            set.remove(num);
            max = Math.max(low+high+1, max);
        }
        return max;


    }
}
