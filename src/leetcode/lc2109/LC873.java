package leetcode.lc2109;

import java.util.HashSet;
import java.util.Set;

/*
873. Length of Longest Fibonacci Subsequence
 */
public class LC873 {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length - 1; j++) {
                int count = 0;
                int a = arr[i], b = arr[j];
                int sum = a + b;
                if (sum>arr[arr.length-1]) break;
                while (set.contains(sum)) {
                    a = b;
                    b = sum;
                    sum = a + b;
                    count++;
                }
                if (count > 0) count += 2;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC873 lc873 = new LC873();
        lc873.lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50});
    }
}
