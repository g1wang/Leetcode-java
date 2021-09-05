package wc;

import java.util.*;

public class LC5863 {
    public int countQuadruplets(int[] nums) {
        int count=0;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 3; i < nums.length; i++) {
            List<Integer> list = indexMap.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            indexMap.put(nums[i], list);
        }
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (indexMap.containsKey(sum)) {
                        List<Integer> list = indexMap.get(sum);
                        for (int l = 0; l < list.size(); l++) {
                            if (list.get(l) > k) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        LC5863 lc5863 = new LC5863();
        lc5863.countQuadruplets(new int[]{28,8,49,85,37,90,20,8});
    }
}
