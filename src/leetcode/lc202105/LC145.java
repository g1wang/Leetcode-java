package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    void dfs(TreeNode root, List<Integer> list){
        if (root==null) return;
        dfs(root.right,list);
        dfs(root.left,list);
        list.add(root.val);
    }

}
