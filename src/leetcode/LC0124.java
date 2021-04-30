package leetcode;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29
 */
public class LC0124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;

    }

    private int sum(TreeNode root) {
        if (root ==null) return 0;
        int sumLeft=sum(root.left);
        int sumRight=sum(root.right);
        int rootSum =Math.max(root.val, Math.max(sumLeft+root.val, sumRight+root.val));
        max = Math.max(Math.max(rootSum, root.val+sumLeft+sumRight),max);
        return rootSum;
    }
}
