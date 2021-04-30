package leetcode;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29
 */
public class LC0114 {
    TreeNode pre =null;
    public void flatten(TreeNode root) {

        if (root!=null) {
            flatten(root.right);
            flatten(root.left);
            root.right = pre;
            root.left = null;
            pre = root;
        }
    }


}
