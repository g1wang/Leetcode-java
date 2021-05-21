package leetcode.lc202105;

/**
 * 307. Range Sum Query - Mutable
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/21
 */
public class LC307 {
    class NumArray {
        FenwickTree fenwickTree;
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
            fenwickTree = new FenwickTree(nums.length);
            for (int i = 0; i < nums.length; i++) {
                fenwickTree.update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int delta = val-this.nums[index];
            this.nums[index]=val;
            fenwickTree.update(index, delta);
        }

        public int sumRange(int left, int right) {
            return fenwickTree.query(right + 1) - fenwickTree.query(left);
        }
    }

    class FenwickTree {

        int[] tree;

        public FenwickTree(int size) {
            this.tree = new int[size + 1];
        }

        void update(int id, int val) {
            id++;
            while (id < tree.length) {
                tree[id] += val;
                id += (id & -id);
            }
        }

        int query(int id) {
            int result = 0;
            while (id > 0) {
                result += tree[id];
                id -= (id & -id);
            }
            return result;

        }

    }
}
