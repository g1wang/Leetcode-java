package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    void dfs(TreeNode root, List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}
