package leetcode;

/**
 * 98. Validate Binary Search Tree
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29 15:52
 */
public class LC0098 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean valid(TreeNode node, long maxValue, long minValue) {
        if (node == null) return true;
        if (node.val >= maxValue || node.val <= minValue) return false;
        return valid(node.left, node.val, minValue) && valid(node.right, maxValue, node.val);
    }
}
