package leetcode.lc202105;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int ans = 0, max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1, childSize = 0, level = 1;
        while (!queue.isEmpty()) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    childSize++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    childSize++;
                }
                sum += node.val;
            }
            size = childSize;
            childSize=0;
            if (sum > max) {
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
