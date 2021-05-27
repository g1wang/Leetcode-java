package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/27
 */
public class LC894 {
    public List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> ret = new ArrayList<>();
        if (n % 2 == 0) return ret;
        if (n == 1) {
            TreeNode head = new TreeNode(0);
            ret.add(head);
            return ret;
        }
        for (int i = 1; i <= (n - 1) / 2; i += 2) {
            List<TreeNode> part1 = allPossibleFBT(i);
            List<TreeNode> part2 = allPossibleFBT(n - 1 - i);
            if (!part1.isEmpty() && !part2.isEmpty()) {
                for (int j = 0; j < part1.size(); j++) {
                    for (int k = 0; k < part2.size(); k++) {
                        TreeNode head = new TreeNode(0);
                        head.left = part1.get(j);
                        head.right = part2.get(k);
                        ret.add(head);
                        if (i != n - 1 - i) {
                            head = new TreeNode(0);
                            head.right = part1.get(j);
                            head.left = part2.get(k);
                            ret.add(head);
                        }
                    }
                }
            }
        }
        return ret;
    }
}
