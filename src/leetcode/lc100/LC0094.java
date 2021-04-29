package leetcode.lc100;


import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/28 21:56
 */
public class LC0094 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        add(root,list);
        return list;
    }

    private void add(TreeNode node,List<Integer> list){
        if (node == null) return;
        if (node.left!=null){
            add(node.left,list);
        }
        list.add(node.val);
        if (node.right!=null){
            add(node.right,list);
        }
    }
}
