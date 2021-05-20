package leetcode.lc202105;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 327. Count of Range Sum
 * https://leetcode.com/problems/count-of-range-sum/
 *
 * FenwickTree 350ms
 * best merge sort
 * @author CodeX
 * @version 1.0
 * @date 2021/5/20
 */
public class LC327 {

    class FenwickTree {
        long size;
        long[] tree;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new long[size + 1];
        }

        public long query(int idx) {
            long result = 0;
            while (idx > 0) {
                result += tree[idx];
                idx -= idx & -idx;
            }
            return result;
        }

        public void update(int idx, int delta) {
            while (idx <= size) {
                tree[idx] += delta;
                idx += idx & -idx;
            }
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        int count = 0, n = nums.length;
        long[] sums = new long[n];

        for (int i = 0; i < n; i++) {
            if (i > 0) sums[i] += sums[i - 1];
            sums[i] += nums[i];
            if (sums[i] >= lower && sums[i] <= upper) count++;
        }
        long[] sorted = Arrays.copyOf(sums, sums.length);
        Arrays.sort(sorted);
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        Map<Long, Integer> idxMap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                treeMap.put(sorted[i], ++idx);
                idxMap.put(sorted[i], idx);
            }
        }
        FenwickTree fenwickTree = new FenwickTree(idxMap.size());
        for (int i = 0; i < n; i++) {
            Map.Entry<Long, Integer> rightBound = treeMap.lowerEntry(sums[i] - lower + 1);
            Map.Entry<Long, Integer> leftBound = treeMap.lowerEntry(sums[i] - upper);
            if (rightBound != null){
                int rightPos = rightBound.getValue();
                int leftPos = leftBound == null ? 0 : leftBound.getValue();
                count += fenwickTree.query(rightPos) - fenwickTree.query(leftPos);

            }
            fenwickTree.update(idxMap.get(sums[i]), 1);
        }
        return count;

    }

    public static void main(String[] args) {
        LC327 lc327 = new LC327();
//        int[] nums = new int[]{0,0};
//        int val = lc327.countRangeSum(nums, 0, 0);
        int[] nums = new int[]{-2, 5, -1};
        int val = lc327.countRangeSum(nums, -2, 2);
        System.out.println(val);

    }

}
