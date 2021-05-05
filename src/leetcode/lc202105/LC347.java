package leetcode.lc202105;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }
        List<Integer>[] freqArr = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (freqArr[entry.getValue()] == null) {
                freqArr[entry.getValue()] = new ArrayList<>();
            }
            freqArr[entry.getValue()].add(entry.getKey());
        }
        int[] ans = new int[k];
        for (int i = freqArr.length - 1, j = 0; i >= 0 && j < k; i--) {
            if (freqArr[i] != null) {
                for (int num : freqArr[i]) {
                    ans[j] = num;
                    j++;
                }
            }
        }
        return ans;
    }
}
