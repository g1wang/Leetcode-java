package bwc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/contest/biweekly-contest-60/problems/find-all-groups-of-farmland/
 */
public class LC5847 {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int right = j + 1;
                    while (right < n && land[i][right] == 1) {
                        right++;
                    }
                    right--;
                    int bot = i + 1;
                    while (bot < m && land[bot][j] == 1) {
                        bot++;
                    }
                    bot--;
                    for (int k = i; k <= bot; k++) {
                        for (int l = j; l <= right; l++) {
                            land[k][l] = 0;
                        }
                    }
                    list.add(new int[]{i, j, bot, right});
                }
            }
        }
        int[][] ans = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }


}
