package leetcode.lc202105;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;

    }
}
