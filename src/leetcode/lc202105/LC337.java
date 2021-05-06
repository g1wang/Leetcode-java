package leetcode.lc202105;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/6
 */
public class LC337 {
    public int rob(TreeNode root) {
        //Map<TreeNode,Integer> dpMap = new HashMap<>();
        //dfs(root,dpMap);
        dfs(root);
        return root.val;
    }

    private void dfs(TreeNode root) {
        if (root==null) return;
        //dfs(root.left,dpMap);
        dfs(root.left);
        //dfs(root.right,dpMap);
        dfs(root.right);
//        int leftMax = dpMap.getOrDefault(root.left,0);
//        int rightMax = dpMap.getOrDefault(root.right,0);
        int leftMax = 0;
        int rightMax = 0;
        int left = 0,right = 0;
        if (root.left!=null) {
            left = root.left.val;
            leftMax += root.left.left==null?0:root.left.left.val;
            leftMax += root.left.right==null?0:root.left.right.val;
        }
        if (root.right!=null) {
            right = root.right.val;
            rightMax +=root.right.left==null?0:root.right.left.val;
            rightMax+=root.right.right==null?0:root.right.right.val;
        }
        int max = Math.max(leftMax+rightMax+root.val,left+right);
        root.val = max;
        //dpMap.put(root,left+right);
    }
}
