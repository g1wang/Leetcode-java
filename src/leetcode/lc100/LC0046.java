package leetcode.lc100;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/7 14:37
 */
public class LC0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        permute(nums, retList, new ArrayList<>());
        return retList;
    }

    void permute(int[] nums, List<List<Integer>> retList, List<Integer> list) {
        if (list.size() == nums.length) {
            retList.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                List<Integer> nextList = new ArrayList<>(list);
                nextList.add(nums[i]);
                permute(nums, retList, nextList);
            }

        }
    }
}
