package leetcode.lc202103;

import java.util.*;

/*
Combination Sum II
 */
public class LC0040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, list, retList, 0);
        return retList;
    }

    private void combine(int[] candidates, int target, List<Integer> list, List<List<Integer>> retList, int s) {
        if (target == 0) {
            retList.add(new ArrayList<>(list));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            combine(candidates, target - candidates[i], list, retList, i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
