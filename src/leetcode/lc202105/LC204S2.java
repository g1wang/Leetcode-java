package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC204S2 {
    public int countPrimes(int n) {
        if (n<=2) return 0;
        int ans=0;
        boolean[] status = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!status[i]){
                //mark
                for (int j = i*i; j < n; j+=i) {
                    status[j]=true;
                }
            }
        }
        for (int i = 2; i <n ; i++) {
            if (!status[i]) ans++;
        }
        return ans;
    }
}
