package leetcode.lc202105;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * sliding windows +Array
 * @author CodeX
 * @version 1.0
 * @date 2021/5/11
 */
public class LC438S2 {

    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> ans = new ArrayList<>();
        final int sz = p.length();
        if (sz > s.length()) {
            return ans;
        }

        final int[] target = new int[26];
        for (char c: p.toCharArray()) {
            target[c-'a']++;
        }

        final char[] cs = s.toCharArray();
        final int[] window = new int[26];
        int cnt = 0;
        for (int r=0; r<cs.length; r++) {
            int idx = cs[r] - 'a';
            window[idx]++;
            if (window[idx] <= target[idx]) {
                cnt++;
            }
            if (r >= sz) {
                int idx_l = cs[r-sz] - 'a';
                window[idx_l]--;
                if (window[idx_l] < target[idx_l]) {
                    cnt--;
                }
            }
            if (cnt == sz) {
                ans.add(r-sz+1);
            }
        }
        return ans;
    }
}
