package leetcode;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29 9:28
 */
public class LC0114 {
    public void flatten(TreeNode root) {
        if (root!=null) {
            TreeNode node = new TreeNode(root.val);
            TreeNode ans = node;
            preRead(root,node);
            root = ans;
        }
    }

    private void preRead(TreeNode root,TreeNode node){

        if (root.left!=null) {
            node.right= new TreeNode(root.left.val);
            node = node.right;
            preRead(root.left,node);
        }
        if (root.right!=null) {
            node.right = new TreeNode(root.right.val);
            node = node.right;
            preRead(root.right, node);
        }
    }
}
