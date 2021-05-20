package leetcode.lc202105;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/20
 */
public class LC205 {
    public boolean isIsomorphic(String s, String t) {
        int[] memo = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (memo[s.charAt(i)]!=memo[t.charAt(i)+128]) return false;
            memo[s.charAt(i)]=memo[t.charAt(i)+128]=i+1;
        }
        return true;
    }



}
