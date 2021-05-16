package leetcode.lc202105;

import java.util.*;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * map list 存储顶点关系 79%
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC210S2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> reqMap = new HashMap<>();
        boolean[] finish = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = reqMap.getOrDefault(prerequisites[i][0], new ArrayList<>());
            list.add(prerequisites[i][1]);
            reqMap.put(prerequisites[i][0], list);
        }
        List<Integer> checked = new ArrayList<>();
        Set<Integer> curReq = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(reqMap, i, finish, curReq, checked)) break;
        }
        if (checked.size() == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < checked.size(); i++) {
                ans[i] = checked.get(i);
            }
            return ans;
        } else return new int[]{};
    }

    private boolean dfs(Map<Integer, List<Integer>> reqMap, int cur, boolean[] finish, Set<Integer> curReq, List<Integer> checked) {

        if (finish[cur]) return true;
        if (!reqMap.containsKey(cur)) {
            finish[cur] = true;
            checked.add(cur);
            return true;
        }
        curReq.add(cur);
        List<Integer> list = reqMap.get(cur);
        for (int i = 0; i < list.size(); i++) {
            if (curReq.contains(list.get(i))) return false;
            if (!dfs(reqMap, list.get(i), finish, curReq, checked)) return false;
        }
        finish[cur] = true;
        checked.add(cur);
        curReq.remove(cur);
        return true;
    }

}
