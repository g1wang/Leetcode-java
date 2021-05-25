package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/25
 */
public class LC797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        boolean[] dp = new boolean[graph.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, 0, list, ans, dp);
        return ans;

    }

    private boolean dfs(int[][] graph, int i, List<Integer> list, List<List<Integer>> ans, boolean[] dp) {
        if (i == graph.length - 1) {
            ans.add(new ArrayList<>(list));
            return true;
        }
        if (dp[i]) return false;
        if (graph[i].length == 0) dp[i] = true;
        boolean hasPath = false;
        for (int j = 0; j < graph[i].length; j++) {
            list.add(graph[i][j]);
            boolean result = dfs(graph, graph[i][j], list, ans, dp);
            if (!result) dp[graph[i][j]] = true;
            if (result) hasPath = true;
            list.remove(list.size() - 1);
        }
        return hasPath;
    }


}
