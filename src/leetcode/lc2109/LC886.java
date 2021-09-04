package leetcode.lc2109;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
886. Possible Bipartition
Runtime: 206 ms, faster than 5.04% of Java online submissions for Possible Bipartition.
Memory Usage: 114.4 MB, less than 5.04% of Java online submissions for Possible Bipartition.
 */
public class LC886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Set<Integer> posSet = new HashSet<>();
        Set<Integer> dislikeSet = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            Set disSet;
            if (map.get(dislike[0]) == null) {
                disSet = new HashSet();
            } else {
                disSet = map.get(dislike[0]);
            }
            disSet.add(dislike[1]);
            map.put(dislike[0], disSet);
            //互斥，可以只不考虑连通的部分
            Set disSet2;
            if (map.get(dislike[1]) == null) {
                disSet2 = new HashSet();
            } else {
                disSet2 = map.get(dislike[1]);
            }
            disSet2.add(dislike[0]);
            map.put(dislike[1], disSet2);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (!seen.contains(entry.getKey())) {
                seen.add(entry.getKey());
                posSet.add(entry.getKey());
                boolean result = dfs(posSet, dislikeSet, map, seen, entry.getKey());
                if (!result) return false;
            }
        }
        return true;

    }


    private boolean dfs(Set<Integer> posSet, Set<Integer> dislikeSet, Map<Integer, Set<Integer>> map, Set<Integer> seen, Integer person) {
        Set<Integer> perDisSet = map.get(person);
        dislikeSet.addAll(perDisSet);
        for (Integer perDis : perDisSet) {
            if (posSet.contains(perDis)) return false;
            if (!seen.contains(perDis)) {
                seen.add(perDis);
                boolean result = dfs(dislikeSet, posSet, map, seen, perDis);
                if (!result) return false;
            }
        }
        return true;

    }
}


