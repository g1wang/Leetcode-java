package leetcode.lc202105;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 *
 * ref:560. Subarray Sum Equals K
 * @author CodeX
 * @version 1.0
 * @date 2021/5/12
 */
public class LC437 {

    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        dfs(root,targetSum,0,map);
        return count;
    }

    void dfs(TreeNode root, int target,int sum, Map<Integer,Integer> map){
        if (root==null) return;
        sum += root.val;
        if (map.containsKey(sum-target)){
            count+=map.get(sum-target);
        }
        int cur = map.getOrDefault(sum,0);
        map.put(sum,cur+1);
        dfs(root.left,target,sum,map);
        dfs(root.right,target,sum,map);
        map.put(sum,cur);
    }

}
