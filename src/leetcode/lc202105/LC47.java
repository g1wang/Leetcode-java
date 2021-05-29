package leetcode.lc202105;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/26
 */
public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans, set);
        return ans;
    }

    private void permute(int[] nums, int idx, List<List<Integer>> ans, Set<List<Integer>> set) {
        if (idx == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            if (!set.contains(list)) {
                set.add(list);
                ans.add(list);
            }
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permute(nums, idx + 1, ans, set);
            swap(nums, idx, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

