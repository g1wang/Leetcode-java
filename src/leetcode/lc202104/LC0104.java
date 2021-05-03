package leetcode.lc202104;



/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29
 */
public class LC0104 {
    public int maxDepth(TreeNode root) {
        return count(root,0);
    }
    private int count(TreeNode node,int depth){
        if (node==null) return depth;
        return Math.max(count(node.left,depth+1),count(node.right,depth+1));

    }
}
