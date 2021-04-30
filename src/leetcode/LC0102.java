package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29
 */
public class LC0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root==null) return null;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size=1;
        while (!queue.isEmpty()){
            int count =0 ;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                    count++;
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    count++;
                }
            }
            size =count;
            ans.add(list);
        }

       return ans;

    }


}


