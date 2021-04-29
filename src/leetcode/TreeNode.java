package leetcode;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/28 22:01
 */
public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
    }
}
