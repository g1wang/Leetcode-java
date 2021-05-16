package leetcode.lc202105;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * 顶点连接数组 12%
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean status[][] = new boolean[numCourses][numCourses];
        boolean[] finish = new boolean[numCourses];
        int[] ans = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            status[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        List<Integer> checked = new ArrayList<>();
        Set<Integer> curReq = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(status, i, finish, curReq, checked)) break;
        }
        if (checked.size() == numCourses) {
            for (int i = 0; i < checked.size(); i++) {
                ans[i] = checked.get(i);
            }
            return ans;
        } else return new int[]{};
    }

    private boolean dfs(boolean[][] status, int cur, boolean[] finish, Set<Integer> curReq, List<Integer> checked) {
        if (finish[cur]) return true;
        curReq.add(cur);
        for (int i = 0; i < status.length; i++) {
            if (finish[i]) continue;
            if (status[cur][i]){
                if (curReq.contains(i)) return false;
                if (!dfs(status,i,finish,curReq,checked)) return false;
            }
        }
        finish[cur] = true;
        checked.add(cur);
        curReq.remove(cur);
        return true;
    }

}
