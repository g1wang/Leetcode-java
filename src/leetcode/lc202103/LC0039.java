package leetcode.lc202103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Combination Sum
 */
public class LC0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, 0, list, retList);
        return retList;
    }

    private void combination(int[] candidates, int target, int s, List<Integer> list, List<List<Integer>> retList) {
        if (target == 0) {
            retList.add(new ArrayList<>(list));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            combination(candidates, target - candidates[i], i, list, retList);
            list.remove(list.size() - 1);
        }
    }
}
