package leetcode.lc202105;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC149 {
//    public int maxPoints(int[][] points) {
//        int n = points.length;
//        boolean[][] dp = new boolean[n][n];
//        int max = 1;
//
//        Map<Pair<Float, Float>, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                if (dp[i][j]) continue;
//                Float k = null, b;
//                if ((points[i][0] - points[j][0]) == 0) {
//                    b = (float) points[i][0];
//                } else {
//                    k = (float) (points[i][1] - points[j][1]) / (float) (points[i][0] - points[j][0]);
//                    b = points[i][1] - k * points[i][0];
//                }
//                Pair<Float, Float> pair = new Pair<>(k, b);
//                List<Integer> list = map.get(pair);
//                if (list == null) {
//                    list = new ArrayList<>();
//                    list.add(i);
//                }
//                for (Integer idx : list) {
//                    dp[idx][j] = true;
//                }
//                list.add(j);
//                max = Math.max(max, list.size());
//                map.put(pair, list);
//            }
//        }
//        return max;
//    }
}
