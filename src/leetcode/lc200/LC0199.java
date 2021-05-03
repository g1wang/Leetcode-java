package leetcode.lc200;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class LC0199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        int size = 1;
        int count =0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            size--;
            if (node!=null){
                if (count==0) ans.add(node.val);
                queue.offer(node.right);
                queue.offer(node.left);
                count+=2;
            }
            if (size==0) {
                size = count;
                count=0;
            }
        }
        return ans;

    }


}
