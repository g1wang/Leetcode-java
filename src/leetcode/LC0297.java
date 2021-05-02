package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
297. Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class LC0297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return bfs(root);

        }

        String bfs(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            StringBuffer nsb = new StringBuffer();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            sb.append("[");
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(nsb);
                    nsb = new StringBuffer();
                    sb.append(node.val);
                    sb.append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else nsb.append("null,");
            }
            //
            sb.deleteCharAt(sb.length() - 1).append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            data = data.replace("[", "").replace("]", "");
            if (data.isEmpty()) return null;
            TreeNode root = new TreeNode();
            String[] strs = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            root.val = Integer.valueOf(strs[0]);
            queue.offer(root);
            int sIndex = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                String s;
                if (sIndex < strs.length && !(s = strs[sIndex++]).equals("null")) {
                    TreeNode left = new TreeNode(Integer.valueOf(s));
                    node.left = left;
                    queue.offer(left);
                }
                if (sIndex < strs.length && !(s = strs[sIndex++]).equals("null")) {
                    TreeNode right = new TreeNode(Integer.valueOf(s));
                    node.right = right;
                    queue.offer(right);
                }

            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
