package leetcode.lc2109;

import java.lang.reflect.Array;
import java.util.*;

/*
873. Length of Longest Fibonacci Subsequence
 */
public class LC873S2 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (dp[i][j] == 1) continue;
                int count = 2;
                int a = i, b = j;
                int sum = arr[a] + arr[b];
                if (sum > arr[n - 1]) break;
                while (map.containsKey(sum)) {
                    int index = map.get(sum);
                    dp[a][b] = 1;
                    a = b;
                    b = index;
                    sum = arr[a] + arr[b];
                    count++;
                    if (sum > arr[n - 1]) break;
                }
                max = Math.max(max, count);
            }
        }
        return max >= 3 ? max : 0;
    }

    public static void main(String[] args) {
        LC873S2 lc873 = new LC873S2();
        lc873.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
    }
}
