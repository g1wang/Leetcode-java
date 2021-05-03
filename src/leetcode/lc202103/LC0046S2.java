package leetcode.lc202103;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/7 16:26
 */
public class LC0046S2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        permute(nums, retList, 0);
        return retList;

    }

    void permute(int[] nums, List<List<Integer>> retList, int idx) {
        if (idx == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            retList.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permute(nums, retList, idx + 1);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int idx, int i) {
        int tmp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = tmp;
    }
}
