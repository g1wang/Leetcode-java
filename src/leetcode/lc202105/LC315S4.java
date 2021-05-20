package leetcode.lc202105;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC315S4 {

    private static int lowbit(int x) {
        return x & (-x);
    }

    class FenwickTree {
        private int[] sums;

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        Map<Integer, Integer> sortIdxMap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < sortNums.length; ++i)
            if (i == 0 || sortNums[i] != sortNums[i - 1])
                sortIdxMap.put(sortNums[i], ++idx);
        FenwickTree fenwickTree = new FenwickTree(sortIdxMap.size());
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = sortIdxMap.get(nums[i]);
            ans.add(fenwickTree.query(pos - 1));
            fenwickTree.update(pos, 1);
        }
        Collections.reverse(ans);
        return ans;

    }

}
