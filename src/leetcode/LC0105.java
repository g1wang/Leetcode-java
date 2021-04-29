package leetcode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/29 8:55
 */
public class LC0105 {

    public static void main(String[] args) {
        LC0105 lc0105 = new LC0105();
        lc0105.buildTree(new int[]{1,2},new int[]{2,1});
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, preorder.length - 1,0, preorder.length - 1);

    }

    private TreeNode build(int[] preorder, int[] inorder, int prestart,int preend,int instart, int inend) {

        if (instart>inend) return null;
        if (instart == inend) return new TreeNode(inorder[instart]);

        //find root in inorder
        int rootIn = 0;
        for (int i = instart; i <= inend; i++) {
            if (preorder[prestart] == inorder[i]) {
                rootIn = i;
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[prestart]);

        node.left = build(preorder, inorder,prestart+1,prestart+rootIn-instart, instart, rootIn - 1);
        node.right = build(preorder, inorder,prestart+rootIn-instart+1,preend, rootIn + 1, inend);
        return node;

    }


}
