package leetcode.lc202105;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean l2r = true;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int childSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (l2r){
                    list.add(node.val);
                }else list.add(0,node.val);
                queue.offer(node.left);
                queue.offer(node.right);
                childSize += 2;
            }
            if (!list.isEmpty()) ans.add(list);
            l2r = !l2r;
            size = childSize;
        }

        return ans;
    }

}
