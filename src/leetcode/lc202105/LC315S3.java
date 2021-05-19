package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * TLE Time Limit Exceeded
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC315S3 {
    class BSTree {
        TreeNode root = null;

        int insert(int key) {
            TreeNode node = this.root;
            if (node == null) {
                this.root = new TreeNode(key, 1);
                return 0;
            } else {
                TreeNode parent;
                boolean cmp;
                int leftCount = 0;
                do {
                    parent = node;
                    if (key == node.key) {
                        node.cnt++;
                        return leftCount + node.leftCnt;
                    } else if (cmp = (key < node.key)) {
                        node.leftCnt++;
                        node = node.left;
                    } else {
                        node.rightCnt++;
                        leftCount += node.leftCnt + node.cnt;
                        node = node.right;
                    }
                } while (node != null);
                TreeNode n = new TreeNode(key, 1);
                if (cmp) {
                    parent.left = n;
                } else {
                    parent.right = n;
                }
                return leftCount;
            }
        }
    }

    class TreeNode {
        int key;
        int cnt;
        int leftCnt;
        int rightCnt;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ansList = new ArrayList<>();

        int n = nums.length;
        BSTree bsTree = new BSTree();
        for (int i = n - 1; i >= 0; i--) {
            ansList.add(0, bsTree.insert(nums[i]));
        }
        return ansList;
    }

    public static void main(String[] args) {
        LC315S3 lc315S2 = new LC315S3();
        List<Integer> list = lc315S2.countSmaller(new int[]{5, 2, 6, 1, 4, 2, 9, 6, 10});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
