package leetcode.lc202105;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/20
 */
public class LC315S5 {

    class FenwickTree {
        private int[] tree;

        public FenwickTree(int n) {
            tree = new int[n+1];
        }

        public void update(int i, int delta) {
            i++;
            while (i < tree.length) {
                tree[i] += delta;
                i += (i & -i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= (i & -i);
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int size = max - min + 1; // total possible values in nums plus one dummy
        int offset = -min; // offset negative to non-negative
        FenwickTree fenwickTree = new FenwickTree(size);
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = nums[i] + offset;
            ans.add(fenwickTree.query(pos));
            fenwickTree.update(pos, 1);
        }
        Collections.reverse(ans);
        return ans;

    }

}
