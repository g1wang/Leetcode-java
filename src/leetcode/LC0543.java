package leetcode;

/*
543. Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class LC0543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max>0?max-1:max;
    }
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        root.val = Math.max(l, r) + 1;
        max = Math.max(r + l + 1, max);
        return root.val;
    }
}
