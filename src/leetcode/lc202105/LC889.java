package leetcode.lc202105;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class LC889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }
        return construct(pre, postMap, 0, pre.length, 0, post.length);
    }

    private TreeNode construct(int[] pre, Map<Integer, Integer> postMap, int preS, int preE, int postS, int postE) {
        if (preS == preE) return null;
        TreeNode root = new TreeNode(pre[preS]);
        preS++;
        postE--;
        if (preS == preE) return root;
        int pivot = postMap.get(pre[preS])+1;
        int preM = preS + pivot - postS;
        root.left = construct(pre, postMap, preS, preM, postS, pivot);
        root.right = construct(pre, postMap, preM, preE, pivot, postE);
        return root;
    }


}

/*class Solution {
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length != post.length){
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex++]);
        if(root.val != post[postIndex]){
            root.left = constructFromPrePost(pre, post);
        }
        if(root.val != post[postIndex]){
            root.right = constructFromPrePost(pre, post);
        }
        ++postIndex;
        return root;
    }
}*/
