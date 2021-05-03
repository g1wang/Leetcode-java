package leetcode.lc300;



/*
236. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LC0236 {

    TreeNode lcs = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        boolean left = dfsFind(root.left, p, q);
        if (lcs != null) return lcs;
        if (left) return root;
        dfsFind(root.right, p, q);
        return lcs;
    }

    boolean dfsFind(TreeNode root, TreeNode p, TreeNode q) {
        boolean result = false;
        if (root==null) return false;
        if (root == p || root == q) result =true;
        boolean left = dfsFind(root.left, p, q);;
        if (lcs != null) return true;
        if (result&&left) {
            lcs=root;
            return true;
        }
        boolean right  = dfsFind(root.right, p, q);
        if ((result||left) && right && lcs == null) {
            lcs = root;
            return true;
        }
        return result||left||right;
    }
}
