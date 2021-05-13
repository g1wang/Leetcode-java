package leetcode.lc202105;

import java.util.*;

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n!=1){
            int sum=0;
            while (n>0){
                int x = n%10;
                sum+=x*x;
                n/=10;
            }
            n=sum;
            if (set.contains(n)) break;
            set.add(n);
        }
        return n==1;

    }
    /*public boolean isHappy(int n) {
        Set<List<Integer>> set = new HashSet<>();
        while (n!=1){
        List<Integer> list = new ArrayList<>();
            int sum=0;
            while (n>0){
                int x = n%10;
                list.add(x);
                sum+=x*x;
                n/=10;
            }
            Collections.sort(list);
            n=sum;
            if (set.contains(list)) break;
            set.add(list);
        }
        return n==1;

    }*/
}
