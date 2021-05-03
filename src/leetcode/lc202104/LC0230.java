package leetcode.lc202104;



import java.util.PriorityQueue;
import java.util.Queue;

/*
230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class LC0230 {
    public int kthSmallest(TreeNode root, int k) {

        Queue<Integer> pq = new PriorityQueue<Integer>(((a,b)->{
            if (a>b)
            return -1;
            return 1;
        }));
        dfs(root,pq,k);
        return pq.peek();

    }

    private void dfs(TreeNode root, Queue<Integer> pq, int k) {
        if (root==null) return;
        if (pq.size()<k||root.val<pq.peek())pq.offer(root.val);
        if (pq.size()>k) pq.poll();
        dfs(root.left,pq,k);
        dfs(root.right,pq,k);
    }
}
