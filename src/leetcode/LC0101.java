package leetcode;

/**
 * Symmetric Tree
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/28 21:56
 */
public class LC0101 {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        return compare(root.left, root.right);


    }

    private boolean compare(TreeNode l, TreeNode r) {
        if (l != null && r != null && l.val == r.val) {
            return compare(l.left, r.right) && compare(l.right, r.left);
        } else if (l==null&&r==null) return true;
        else return false;

    }


}


