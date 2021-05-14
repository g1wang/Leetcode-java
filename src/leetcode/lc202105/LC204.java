package leetcode.lc202105;

import java.util.ArrayList;
import java.util.List;

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 *
 * 	Time Limit Exceeded
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC204 {
    public int countPrimes(int n) {
        if (n<=2) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= (int)Math.sqrt(n); i++) {
            boolean isPrime = true;
            for (int j = 0; j < list.size(); j++) {
                if (i % list.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) list.add(i);
        }
        return list.size();
    }
}
