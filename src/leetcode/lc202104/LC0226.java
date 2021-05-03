package leetcode.lc202104;



/*
226. Invert Binary Tree
 */
public class LC0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }


}
