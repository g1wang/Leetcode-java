package leetcode.lc202105;

import java.util.Arrays;

/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/19
 */
public class LC274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        /*for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                ans = citations.length - i;
                break;
            }
        }*/
        for (int i = citations.length-1; i >=0; i--) {
            if (citations[i] >= citations.length - i) {
                ans = citations.length - i;

            }else break;
        }
        return ans;

    }

    /*public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if (citations[i] > n) {
                arr[n] += 1;
            }
            else {
                arr[citations[i]] += 1;
            }
        }
        for (int i = n-1; i >= 0; i--) {
            arr[i] += arr[i+1];
        }
        for (int i = n; i >= 0; i--) {
            if (arr[i] >= i) {
                return i;
            }
        }
        return 0;
    }*/
}
