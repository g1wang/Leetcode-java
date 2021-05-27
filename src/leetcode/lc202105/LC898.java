package leetcode.lc202105;

import java.util.HashSet;
import java.util.Set;

/**
 * 898. Bitwise ORs of Subarrays
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 * <p>
 * 337ms
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/27
 */
public class LC898 {

    /*
    //136ms
    public int subarrayBitwiseORs(int[] arr) {
        Set set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j]) {
                    break;
                }
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }*/

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (i>0&&arr[i]==arr[i-1]) continue;
            Set<Integer> nextSet = new HashSet<>();
            for (Integer num : set) {
                int result =num | arr[i];
                nextSet.add(result);
                ans.add(result);
            }
            nextSet.add(arr[i]);
            ans.add(arr[i]);
            set=nextSet;
        }
        return ans.size();
    }
}
