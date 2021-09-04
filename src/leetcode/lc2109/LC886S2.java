package leetcode.lc2109;

import java.util.*;

/*
Runtime: 43 ms, faster than 25.67% of Java online submissions for Possible Bipartition.
Memory Usage: 47.4 MB, less than 54.42% of Java online submissions for Possible Bipartition.
 */
public class LC886S2 {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Set<Integer> seen = new HashSet<>();
        Map<Integer, String> status = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            List<Integer> list;
            if (map.get(dislike[0]) == null) {
                list = new ArrayList<>();
            } else {
                list = map.get(dislike[0]);
            }
            list.add(dislike[1]);
            map.put(dislike[0], list);
            //互斥，可以只不考虑连通的部分
            List<Integer> list2;
            if (map.get(dislike[1]) == null) {
                list2 = new ArrayList<>();
            } else {
                list2 = map.get(dislike[1]);
            }
            list2.add(dislike[0]);
            map.put(dislike[1], list2);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (!seen.contains(entry.getKey())) {
                status.put(entry.getKey(), "Red");
                boolean result = dfs(map, status, entry.getKey(), "Red",seen);
                if (!result) return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Map<Integer, String> status, Integer key, String color, Set<Integer> seen) {
        seen.add(key);
        String curColor = "RED";
        if (color.equals("RED")) curColor = "BLACK";
        List<Integer> list = map.get(key);
        for (Integer person : list) {
            if (status.getOrDefault(person, "NONE").equals(color)) return false;
            else status.put(person, curColor);
            if (seen.contains(person)) continue;
            boolean result = dfs(map, status, person, curColor, seen);
            if (!result) return false;
        }
        return true;
    }


}
