package leetcode.lc202105;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])){
                ans= new int[]{map.get(target-numbers[i])+1,i+1};
                break;
            }
            map.put(numbers[i],i);
        }
        return ans;
    }
}
